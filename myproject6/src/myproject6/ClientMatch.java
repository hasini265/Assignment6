package myproject6;

public class ClientMatch implements Client {
	
	String name;
	String gender;
	String profession;
	String interests;
	int rating;
	int ratingCount = 0;
  
	public String getName() {
		return name;	
	} 
  
	public String getGender() {
		return gender;
	}
	
	public String getProfession() {
		return profession;
	}
  
	public String getInterests() {
		return interests;
	}
   
	public int getLikeOrNotRating() {
		if (ratingCount == 0) return 0;
		return (rating/ratingCount);
	}
  
 
	public void setName(String name) {
		this.name = name;
	}
 
	public void setGender(String gender) {
		this.gender = gender;
	} 
	
	public void setProfession(String profession) {
		this.profession = profession;
	}
  
	public void setInterests(String interests) {
		this.interests = interests;
	} 
  
	public void setLikeOrNotRating(int rating) {
		this.rating += rating;	
		ratingCount++;
	}

}
