package com.semairem.otoGaleri;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Methodlar {
	private static Connection con = null;
//	-------------------------------------------------------------------------------------------------------------------

	public static void arabaEkleme() {
		Scanner scanner = new Scanner(System.in);
		
		OtoGaleri otoGaleri = new OtoGaleri();
		int id = otoGaleri.getId();
		
		String durumu = otoGaleri.getDurumu();
		System.out.println("Aracın Durumunu Yazınız");
		durumu = scanner.next();
		
		System.out.println("Araç Türünü Giriniz(Otomobil, Kamyon, Motor vb)");
		String aracTuru = otoGaleri.getAracTuru();
		aracTuru = scanner.next();
		
		System.out.println("Araç Tipini Giriniz(Satılık/Kiralık)");
		String aracTipi = otoGaleri.getAracTuru();
		aracTipi = scanner.next();
		
		System.out.println("Aracın Modelini Giriniz");
		String modeli = otoGaleri.getModeli();
		modeli = scanner.next();
		
		System.out.println("Yakıt Türünü Giriniz");
		String yakiti = otoGaleri.getYakiti();
		yakiti = scanner.next();
		
		System.out.println("arabanın Markasını Giriniz");
		String markasi = otoGaleri.getMarkasi();
		markasi = scanner.next();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://10.1.8.20:3306/Galeri?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",
					"ogrenci", "1234");
			String sorgu = "INSERT INTO arabaOlusturma ( aracTuru, aracTipi,  markasi, modeli, yakiti,id,durumu) VALUES"
					+ " (?,?,?,?,?,?,?)";
			PreparedStatement prepareStatement = con.prepareStatement(sorgu);
			prepareStatement.setString(1, aracTuru);
			prepareStatement.setString(2, aracTipi);
			prepareStatement.setString(3, markasi);
			prepareStatement.setString(4, modeli);
			prepareStatement.setString(5, yakiti);
			prepareStatement.setInt(6, id);
			prepareStatement.setString(7, durumu);

			prepareStatement.execute();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Hata oluştu. Bağlantı bile kapatılamadı.");
			}
		}
		System.out.println("Kayıt eklendi");
	}

//	----------------------------------------------------------------------------------------------------------------------

	public static void araclariListeleme() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://10.1.8.20:3306/Galeri?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",
					"ogrenci", "1234");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from arabaOlusturma");
			while (rs.next()) {
				String aracTuru = rs.getString(1);
				String aracTipi = rs.getString(2);
				String markasi = rs.getString(3);
				String modeli = rs.getString(4);
				String yakiti = rs.getString(5);
				int id = rs.getInt(6);
				String durumu = rs.getString(7);
				System.out.println(
						"No    Aracın Türü       Aracın Tipi      Aracın Modeli      Aracın Yakıtı     Aracın Markası    Aracın Durumu");
				System.out.println(id + "   -   " + aracTuru + "   -    " + aracTipi + "      -      " + modeli
						+ "   -    " + yakiti + "   -    " + markasi + "   -   " + durumu);
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Hata oluştu. Bağlantı bile kapatılamadı.");
			}
		}
	}

//	-------------------------------------------------------------------------------------------------------------------------------

	public static void calisanEkleme() {
		Scanner scanner = new Scanner(System.in);
		Calisan calisan = new Calisan();
		int id = calisan.getId();
		System.out.println("Çalışanın Adını Giriniz");
		String adi = calisan.getAdi();
		adi = scanner.next();
		System.out.println("Çalışanın Soyadını Giriniz");
		String soyadi = calisan.getSoyadi();
		soyadi = scanner.next();
		System.out.println("Çalışanın Yaşını Giriniz");
		int yasi = calisan.getYasi();
		yasi = scanner.nextInt();
		System.out.println("Çalışanın Görevini Yazınız");
		String gorevi = calisan.getGorevi();
		gorevi = scanner.next();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://10.1.8.20:3306/Galeri?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",
					"ogrenci", "1234");
			String sorgu = "INSERT INTO calisanOlusturma ( id, adi, soyadi, yasi, gorevi) VALUES" + " (?,?,?,?,?)";
			PreparedStatement prepareStatement = con.prepareStatement(sorgu);
			prepareStatement.setInt(1, id);
			prepareStatement.setString(2, adi);
			prepareStatement.setString(3, soyadi);
			prepareStatement.setInt(4, yasi);
			prepareStatement.setString(5, gorevi);

			prepareStatement.execute();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Hata oluştu. Bağlantı bile kapatılamadı.");
			}
		}
		System.out.println("Kayıt eklendi");
	}

//	--------------------------------------------------------------------------------------------------------------------------------

	public static void calisanlariListeleme() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://10.1.8.20:3306/Galeri?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",
					"ogrenci", "1234");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from calisanolusturma");
			while (rs.next()) {
				int id = rs.getInt(1);
				String adi = rs.getString(2);
				String soyadi = rs.getString(3);
				String yasi = rs.getString(4);
				String gorevi = rs.getString(5);

				System.out.println(id + " " + adi + " " + soyadi + " " + yasi + " " + gorevi);
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Hata oluştu. Bağlantı bile kapatılamadı.");
			}
		}

	}

//	--------------------------------------------------------------------------------------------------------------------------------

	public static void araclariSecme() {
		Scanner scanner = new Scanner(System.in);
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://10.1.8.20:3306/Galeri?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",
					"ogrenci", "1234");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from arabaOlusturma");

			System.out.println("Kiralamak veya Satın Almak istedeğiniz Aracın Numarasını Yazınız");
			int alýnacakArabaninIdNumarasi = scanner.nextInt();
			for (int i = 0; i <= alýnacakArabaninIdNumarasi; i++) {
				while (rs.next()) {
					String aracTuru = rs.getString(1);
					String aracTipi = rs.getString(2);
					String markasi = rs.getString(3);
					String modeli = rs.getString(4);
					String yakiti = rs.getString(5);
					int id = rs.getInt(6);
					String durumu = rs.getString(7);
					if (id == alýnacakArabaninIdNumarasi) {
						System.out.println(id + " " + aracTuru + " " + aracTipi + " " + modeli + " " + yakiti + " "
								+ markasi + durumu);
						System.out.println("Kiralamak Veya Satın Almak istediğinize Emin Misiniz?(evet/hayýr)");
						String secim = scanner.next();

						switch (secim) {
						case "evet":
							durumu = "Seçildi";
							System.out.println(
									"No  Aracın Türü   Aracın Tipi     Aracın Modeli    Aracın Yakýtý   Aracın Markasý   Aracın Durumu");
							System.out.println(id + "   -   " + aracTuru + "   -    " + aracTipi + "   -    " + modeli
									+ "   -    " + yakiti + "   -    " + markasi + "   -   " + durumu);
							break;

						case "hayýr":

							break;

						default:
							System.out.println("Hatalı Seçim Yaptınız");
							break;
						}

					}
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Hata oluştu. Bağlantı bile kapatılamadı.");
			}
		}
	}

//	------------------------------------------------------------------------------------------------------------------------------
	public static void aracSorgulama() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("1.Araç Tipi");
		System.out.println("2.Araç Türü");
		System.out.println("3.Markası");
		System.out.println("4.Modeli");
		System.out.println("5.Yakıt Türü");
		System.out.println("Lütfen araç sorgulatmak için sorgulamk istediğiniz başlığınn numarasını yazınız");
		int secimNumarasi = scanner.nextInt();

		System.out.println("Aranacak Deger=");
		String aranacakDeger = "' or '1'='1";

		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://10.1.8.20:3306/Galeri?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey",
					"ogrenci", "1234");
			
			String sorgu = "select * from arabaOlusturma";
			switch (secimNumarasi) {
			case 1:
				sorgu += " where aractipi=?";
				break;
			case 2:
				sorgu += " where aracturu=?";
				break;
			case 3:
				sorgu += " where markasi=?";
				break;
			case 4:
				sorgu += " where modeli=?";
				break;
			case 5:
				sorgu += " where yakitturu=?";
				break;
			default:
				break;
			}
			PreparedStatement prepareStatement = con.prepareStatement(sorgu);
			prepareStatement.setString(1, aranacakDeger);
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				String aracTuru = rs.getString(1);
				String aracTipi = rs.getString(2);
				String markasi = rs.getString(3);
				String modeli = rs.getString(4);
				String yakiti = rs.getString(5);
				int id = rs.getInt(6);
				String durumu = rs.getString(7);

				System.out.println("Araç Türü - " + aracTuru);
				System.out.println("Araç Tipi - " + aracTipi);
				System.out.println("Araç Markası - " + markasi);

			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Hata oluştu. Bağlantı bile kapatılamadı.");
			}
		}

	}

}