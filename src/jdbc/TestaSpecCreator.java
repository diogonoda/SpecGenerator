package jdbc;

import java.io.IOException;

import controller.SpecCreator;

public class TestaSpecCreator {

	public static void main(String[] args) throws IOException {
		new SpecCreator().fileCreator("testando \n 1 \n xxx", "c:\\Diogo\\unitTests\\spec\\teste1.xmk");
	}

}
