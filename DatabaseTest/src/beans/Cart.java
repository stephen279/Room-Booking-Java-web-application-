package beans;

public class Cart {
	
	private String CartUserc ;
	private String message = "problem";
	
	public Cart(){
		
		
	}
	
	public Cart(String cartUserc){
		this.CartUserc = cartUserc;
		
	}
	
	

	public String getCart() {
		return CartUserc;
	}

	public void setCart(String cart) {
		CartUserc = cart;
	}
	
	public Boolean validate() {
		System.out.println("inside cart.validate()");

		/*
		 * if (userName.length()<1){
		 * 
		 * message = "userName field empty"; return false; }
		 * 
		 * if (costumerName.length()<1){
		 * 
		 * message = "costumerName field empty"; return false;
		 * 
		 * }
		 * 
		 * if (location.length()<1){
		 * 
		 * message = "location field empty"; return false;
		 * 
		 * }
		 * 
		 * if (roomPrice.length()<1){
		 * 
		 * message = "roomprice field empty"; return false;
		 * 
		 * }
		 * 
		 * if (roomSize.length()<1){
		 * 
		 * message = "roomSize field  empty"; return false;
		 * 
		 * }
		 * 
		 * if (contact.length()<1){
		 * 
		 * message = "contact field empty"; return false;
		 * 
		 * }
		 */

		return true; // if everything validate ok return true
	}
	public String getMessage() {
		return message ;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
