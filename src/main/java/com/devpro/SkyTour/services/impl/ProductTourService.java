package com.devpro.SkyTour.services.impl;

import java.io.File;
import java.io.IOException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.devpro.SkyTour.dto.ProductSearch;
import com.devpro.SkyTour.model.ProductTour;
import com.devpro.SkyTour.model.ProductTourImages;
import com.devpro.SkyTour.services.BaseService;
import com.devpro.SkyTour.services.PagerData;
import com.github.slugify.Slugify;

@Service
public class ProductTourService extends BaseService<ProductTour>{
	
	@Autowired
	private ProductTourImagesService productTourImagesService;

	@Override
	protected Class<ProductTour> clazz() {
		return ProductTour.class;
	}
//	dùng để kiểm tra xem admin có upload ảnh product hay không
	private boolean isEmptyUploadFile(MultipartFile[] images) {
		if(images == null || images.length <= 0) {
			return true;
		}
		if(images.length == 1 && images[0].getOriginalFilename().isEmpty()) {
			return true;
		}
		return false;
	}
	//
	private boolean isEmptyUploadFile(MultipartFile image) {
		return image == null || image.getOriginalFilename().isEmpty();
	}
	//tạo tên file upload
	private String getUniqueUploadFileName(String fileName) {
		String[] splitFileName = fileName.split("\\.");
		return splitFileName[0]  + System.currentTimeMillis() + "."+ splitFileName[1];
	}
	
	
	//thêm mới sản phẩm
	@Transactional
	public ProductTour addProduct(ProductTour productTour, MultipartFile productAvatar, MultipartFile[] productPictures)throws IllegalStateException, IOException{
		//kiểm tra xem admin có đẩy avatar lên không ???
		if(!isEmptyUploadFile(productAvatar)) {
			String fileName = getUniqueUploadFileName(productAvatar.getOriginalFilename());
			//tạo đường dẫn tới file chứa avatar
			String pathToAvatar = "D:/Computer/Pictures-admin/upload/productTour/avatar/" + fileName;
			
			//luu avatar vào đường dẫn trên
			productAvatar.transferTo(new File(pathToAvatar));
			
			productTour.setAvatar("productTour/avatar/"+fileName);
		}
		if(!isEmptyUploadFile(productPictures)) {
			for(MultipartFile pic : productPictures) {
				String fileName = getUniqueUploadFileName(pic.getOriginalFilename());
				//lưu ảnh admin đẩy lên server
				pic.transferTo(new File("D:/Computer/Pictures-admin/upload/productTour/pictures/" + fileName));
				
				//tạo mới 1 bản ghi 
				ProductTourImages productTourImages = new ProductTourImages();
				productTourImages.setPath("productTour/pictures/"+fileName);
				productTourImages.setTitle(fileName);
				
				productTour.addProductTourImages(productTourImages);
			}
		}
		//tạo seo: bổ sung thêm thời gian tính bằng miliseconds để tránh trùng seo
		Slugify slugify = new Slugify();
		productTour.setSeo(slugify.slugify(productTour.getName()+"-"+System.currentTimeMillis()));
		//lưu vào database
		return super.saveOrUpdate(productTour);
	}
	
	
	//chỉnh sửa sản phẩm
	@Transactional
	public ProductTour editProduct(ProductTour productTour,MultipartFile productAvatar, MultipartFile[] productPictures) throws IllegalStateException, IOException{
		//lấy thông tin cũ của product theo id
		ProductTour productTourInDb = super.getById(productTour.getId());
		
		//có đẩy lại avatar thì ta cần xóa avatar cũ thêm avatar mới
		if(!isEmptyUploadFile(productAvatar)) {
			//xóa avatar trong folder
			new File("D:/Computer/Pictures-admin/upload/"+productTourInDb.getAvatar()).delete();
			
			//update avatar mới
			String fileName = getUniqueUploadFileName(productAvatar.getOriginalFilename());
			//khi update thì ta phải lưu vào trong ổ cứng đã
			productAvatar.transferTo(new File("D:/Computer/Pictures-admin/upload/productTour/avatar/"+fileName));
			//sau đó thiết lập đường dẫn mới cho file ảnh mới
			productTour.setAvatar("productTour/avatar/"+fileName);
		}else {
			//sử dụng lại avatar cũ
			productTour.setAvatar(productTourInDb.getAvatar());
		}
		
		//có đẩy lai pictures
		if(!isEmptyUploadFile(productPictures)) {
			// xóa pictures cũ
			if (productTourInDb.getProductTourImages() != null && productTourInDb.getProductTourImages().size() > 0) {
				for (ProductTourImages opi : productTourInDb.getProductTourImages()) {
					// xóa avatar trong folder lên
					new File("D:/Computer/Pictures-admin/upload/" + opi.getPath()).delete();

					// xóa dữ liệu trong database
					productTourImagesService.delete(opi);
				}
			}

			// update pictures mới
			for (MultipartFile pic : productPictures) {
				String fileName = getUniqueUploadFileName(pic.getOriginalFilename());
				
				pic.transferTo(new File("D:/Computer/Pictures-admin/upload/productTour/pictures/" + fileName));
				
				ProductTourImages pi = new ProductTourImages();
				pi.setPath("product/pictures/" + fileName);
				pi.setTitle(fileName);
				
				productTour.addProductTourImages(pi);
			}
		}
		//tạo seo
		Slugify slugify = new Slugify();
		productTour.setSeo(slugify.slugify(productTour.getName() + "-" + System.currentTimeMillis()));
		
		return super.saveOrUpdate(productTourInDb);
	}
	public PagerData<ProductTour> searchProduct(ProductSearch searchModel) {
		// khởi tạo câu lệnh
		String sql = "SELECT * FROM tbl_product_tour p WHERE 1=1";

		if (searchModel != null) {
			
			// tìm kiếm theo category
			if(searchModel.getCategoryId() != null && !"0".equals(searchModel.getCategoryId())) {
				sql += " and category_id = " + searchModel.getCategoryId();
			}
		

			// tìm kiếm theo title và description
			if (!StringUtils.isEmpty(searchModel.getKeyword())) {
				sql += " and (p.name like '%" + searchModel.getKeyword() + "%'" + 
						     " or p.code like '%" + searchModel.getKeyword() + "%'" + 
						     " or p.name_detail like '%" + searchModel.getKeyword() + "%')";
			}
			// tìm kiếm theo seo
			if(!StringUtils.isEmpty(searchModel.getSeo())) {
				sql += " and seo = '" + searchModel.getSeo() + "'";
			}
		}
		
		return getEntitiesByNativeSQL(sql, searchModel.getPage());
	}
	
}
