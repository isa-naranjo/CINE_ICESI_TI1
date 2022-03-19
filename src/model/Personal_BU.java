package model;

import java.io.*;

public class Personal_BU implements Serializable{
	private  static final long serialVersionUID = 2l;
	private static final String PATH_FILE_STRING ="data/Personal_BU.isa";

	Integer id;

	public Personal_BU(Integer id) {
		
		this.id = id;
	}


	public void saveData() throws IOException {
        File savedInfoFile = new File(PATH_FILE_STRING);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(savedInfoFile));
        oos.writeObject(this);
        oos.close();
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
