package com.semairem.otoGaleri;

import java.util.Scanner;

public class Program {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		boolean donguDevamEdiyor = true;
		do {

			System.out.println("");
			Menu.menuYazdir();
			System.out.println("");
			System.out.print("Seçiminiz=");
			System.out.println("");
			int secim = scanner.nextInt();
			switch (secim) {

			case 1:
				System.out.println("");
				System.out.println("-------------------------------");
				System.out.println("Araç Sorgulanacak");
				System.out.println("-------------------------------");
				System.out.println("");
				Methodlar.aracSorgulama();
				System.out.println("");

				break;

			case 2:
				System.out.println("");
				System.out.println("-------------------------------");
				System.out.println("Araç Eklenecek");
				System.out.println("-------------------------------");
				System.out.println("");
				Methodlar.arabaEkleme();
				System.out.println("");
				break;

			case 3:
				System.out.println("");
				System.out.println("-------------------------------");
				System.out.println("Araç Kiralanacak Veya Satın Alınacak");
				System.out.println("-------------------------------");
				System.out.println("");
				Methodlar.araclariListeleme();
				Methodlar.araclariSecme();

				break;

			case 4:
				System.out.println("");
				System.out.println("-------------------------------");
				System.out.println("Araç Listelenecek");
				System.out.println("-------------------------------");
				System.out.println("");
				Methodlar.araclariListeleme();
				System.out.println("");

				break;

			case 5:
				System.out.println("");
				System.out.println("-------------------------------");
				System.out.println("Çalışanlar Listelenecek");
				System.out.println("-------------------------------");
				System.out.println("");
				Methodlar.calisanlariListeleme();
				System.out.println("");

				break;

			case 6:
				System.out.println("");
				System.out.println("-------------------------------");
				System.out.println("Çalışan Eklenecek");
				System.out.println("-------------------------------");
				System.out.println("");
				Methodlar.calisanEkleme();
				System.out.println("");

				break;

			case 7:
				System.out.println("");
				System.out.println("-------------------------------");
				System.out.println("Çıkış Yapılacak");
				System.out.println("-------------------------------");
				System.out.println("");
				donguDevamEdiyor = false;

				break;

			default:
				System.out.println("");
				System.out.println("-------------------------------");
				System.out.println("Hatalı Seçim Yaptınız");
				System.out.println("-------------------------------");
				System.out.println("");

				break;
			}
		} while (donguDevamEdiyor);
	}

}