package Menu;

import java.util.Random;

public class Data {

	private String kode, name;
	private int harga,stok;
	private Random rand = new Random();
	
	public Data(String name, int harga, int stok) {
		super();
		this.name = name;
		this.harga = harga;
		this.stok = stok;
		
		int code = 0;
		String kodee = "BC-";
		for(int x=0;x<3;x++)
		{
			code = rand.nextInt(10);
			kodee = kodee + code;
		}
		
		this.kode = kodee;
	}
	
	public String getKode() {
		return kode;
	}

	public String getName() {
		return name;
	}

	public int getHarga() {
		return harga;
	}

	public int getStok() {
		return stok;
	}

}
