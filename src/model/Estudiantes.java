package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Estudiantes implements Serializable{
	private  static final long serialVersionUID = 2l;
	private static final String PATH_FILE_STRING ="data/Estudiantes.isa" ;
	String name ;
	Integer id;
	
	
	public Estudiantes(String name, Integer id) {
		
		this.name = name;
		this.id = id;
	}


	public void saveData() throws IOException {
        File savedInfoFile = new File(PATH_FILE_STRING);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(savedInfoFile));
        oos.writeObject(this);
        oos.close();
    }


	


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	
	
	

}
