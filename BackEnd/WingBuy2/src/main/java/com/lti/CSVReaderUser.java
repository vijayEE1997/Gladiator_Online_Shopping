package com.lti;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.lti.model.User;

public class CSVReaderUser {

	public static List<User> load() {

		String csvFile = "C:/Users/91830/Downloads/user_csv.csv";
		String line = "";
		String cvsSplitBy = ",";
		List<User> ulist = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			int c = 0;
			while ((line = br.readLine()) != null) {
				if (c == 0) {
					c++;
					continue;
				}
				// use comma as separator
				String[] userdata = line.split(cvsSplitBy);

				User user = new User();
				user.setuName(userdata[0]);
				user.setuMobile(Long.parseLong(userdata[3]));
				user.setuEmail(userdata[1]);
				user.setuPassword(userdata[2]);
				ulist.add(user);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return ulist;
	}

}