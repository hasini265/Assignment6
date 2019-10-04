package myproject6;

public interface Client {

	String getName();
	String getGender();
	String getProfession();
	String getInterests();
	int getLikeOrNotRating();
 
    void setName(String name);
    void setGender(String gender);
    void setProfession(String profession);
    void setInterests(String interests);
    void setLikeOrNotRating(int rating); 

}
