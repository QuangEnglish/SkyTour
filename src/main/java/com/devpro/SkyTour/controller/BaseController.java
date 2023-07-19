package com.devpro.SkyTour.controller;

public abstract class BaseController {

//	@Autowired
//	private CategoriesService categoriesService;
	
	/**
	 * tất cả request-mapping của child-controller extends từ basecontroller
	 * sẽ tự động gọi các hàm có sử dụng @ModelAltribute
	 * kết quả của hàm sẽ tự động đẩy xuống view
	 */
	
//	@ModelAttribute("categories")
//	public List<Categories> getAllCategories(){
//		return categoriesService.findAll();
//	}
	/**
	 * trả về entity User chính là user logined
	 * User logined có thể truy cập thông qua class SecurityContextHolder
	 * @return
	 */
//	@ModelAttribute("userLogined")
//	public User getUserLogined() {
//		Object userLogined = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		if(userLogined != null && userLogined instanceof UserDetails)
//			return (User) userLogined;
//		
//		return new User();
//	}
	
	/**
	 * Kiểm tra xem người dùng đã đăng nhập chưa?
	 * User logined có thể truy cập thông qua class SecurityContextHolder
	 * @return true|false, true nếu đã login ngược lại trả về false
	 */
//	@ModelAttribute("isLogined")
//	public boolean isLogined() {
//		boolean isLogined = false;
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		if (principal != null && principal instanceof UserDetails) {
//			isLogined = true;
//		}
//		
//		return isLogined;
//	}
}
