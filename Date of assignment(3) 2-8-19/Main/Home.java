package Main;

import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.Scanner;
import java.util.Scanner;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

//import Songs.Album;
import Structures.*;

/**
 * 
 * @author twinkle.lahariya
 *
 */

public class Home {

	public static Songs[] songValues() {

		Songs[] songData = new Songs[8];

		Songs s1 = new Songs("Perfect", "xyz", LocalDate.of(2017, 1, 13));
		Songs s2 = new Songs("Shape Of You", "pqr", LocalDate.of(2017, 1, 13));
		Songs s3 = new Songs("Love Story", "abc", LocalDate.of(2017, 1, 13));
		Songs s4 = new Songs("You Belong With Me", "def", LocalDate.of(2017, 1, 13));
		Songs s5 = new Songs("Channa Mereya", "Ae Dil Hai mushkil", LocalDate.of(2017, 1, 13));
		Songs s6 = new Songs("Tujhe Kitna Chahane Lage ham", "kabir Singh", LocalDate.of(2017, 1, 13));
		Songs s7 = new Songs("Numb", "ghi", LocalDate.of(2017, 1, 13));
		Songs s8 = new Songs("In the end", "jkl", LocalDate.of(2017, 1, 13));

		songData[0] = s1;
		songData[1] = s2;
		songData[2] = s3;
		songData[3] = s4;
		songData[4] = s5;
		songData[5] = s6;
		songData[6] = s7;
		songData[7] = s8;

		return songData;
	}

	public static ArrayList<Library> createData() {

		Songs songData[] = songValues(); // songvalues into songdata array
		ArrayList<Library> libraryList = libraryValues(albumValues(songData));// creating data set
		return libraryList;

	}

	
	/*
	 * function giving values of song data into albums
	 */
	public static ArrayList<Album> albumValues(Songs[] songData) {
		ArrayList<Album> result = new ArrayList<>();
		// TODO Auto-generated method stub
		for (int i = 0; i < 8; i++) {
			Album album = new Album("Album" + (i + 1));
			album.songs.add(songData[i]);
			i += 1;
			album.songs.add(songData[i]);
			result.add(album);
		}

		return result;
	}

	
	
	/*
	 * function giving values of album data to libraries
	 */
	public static ArrayList<Library> libraryValues(ArrayList<Album> albums) {
		ArrayList<Library> result = new ArrayList<>();
		// TODO Auto-generated method stub
		for (int i = 0; i < 4; i++) {
			Library library = new Library("Library" + (i + 1));
			library.albums.add(albums.get(i));
			i++;
			library.albums.add(albums.get(i));
			result.add(library);
		}

		return result;
	}

	public static void main(String[] args) {
																																																															
		// TODO Auto-generated method stub

		System.out.println("00:All Libraries\n01:Library 1\n02:Library 2\nEnter your choice::");

		ArrayList<Library> library = createData();

		Scanner sc = new Scanner(System.in); // creating and initializing the Scanner class for getting user data

		int choice = sc.nextInt(); // taking user choice
		//control shifted to library class
		if (choice == 0) {
			Library.showAllLibraries(library);
		} else if (choice == 1 || choice == 2) {
			Library.showLibraries(library, choice);
		}

	}
}
