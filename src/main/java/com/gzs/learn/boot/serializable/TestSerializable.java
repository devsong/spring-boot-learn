package com.gzs.learn.boot.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

import lombok.Data;

public class TestSerializable {
	String filename = "d:/test.obj";

	@Test
	public void testWriteObject() throws FileNotFoundException, IOException {
		Serializable serializable = new Serializable();
		serializable.setName("test");
		// serializable.setTest("1");
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename));

		os.writeObject(serializable);
		os.close();
	}

	@Test
	public void testReadObject() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
		Serializable s = (Serializable) in.readObject();
		System.out.println(s.getName());
		// System.out.println(s.getTest());
		in.close();
	}

}

@Data
class Serializable implements java.io.Serializable {
	private static final long serialVersionUID = 2L;

	private String name;

	// private String test;
}
