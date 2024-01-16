/**
 * 
 */
package beans;

public enum Gender {
	MALE("男性"),
	FEMALE("女性");
	
	private String genderName;
	private Gender(String genderName) {
		this.genderName = genderName;
	}
	
	@Override
	public String toString() {
		return this.genderName;
	}
}
