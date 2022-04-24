package domain;

import org.apache.ibatis.type.Alias;

@Alias("blog")
public class Blog {
	
	private int id;
	
	private int author_id;
	
	private String title;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the author_id
	 */
	public int getAuthor_id() {
		return author_id;
	}

	/**
	 * @param author_id the author_id to set
	 */
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	

}
