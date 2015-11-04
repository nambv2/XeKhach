package fpt.fsdn.svtt1213.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Security {
	private static Pattern pattern;
	private static Matcher matcher;
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String PASSWORD_PATTERN = "^[a-z0-9]{5,20}$";
	private static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,20}$";
	private static final String DATE_PATTERN = "^(1[0-2]|0?[1-9])/(3[01]|[12][0-9]|0?[1-9])/(?:[0-9]{2})?[0-9]{2}$";// mm/dd/yy

	private static final String TELEPHONE_PATTERN = "^[0-9]{9,11}$";
	private static final String CMND_PATTERN = "^[0-9]{9}$";
	private static final String PRICE_PATTERN = "^[-+]?[0-9]+[.]?[0-9]*([eE][-+]?[0-9]+)?$";
	private static final String ID_PATTERN = "^[a-zA-Z0-9_-]{3,15}$";

	private static final String YEAR_PATTERN = "^[0-9]{3,5}$";

	private static final String BIENSO_PATTERN = "^[1-9]{1}[0-9]{1}[A-Z]{1}[-]([0-9]{2}|[0-9]{3}.)[0-9]{2}";
	
	private static final String ID_VALIDATE_MANV = "^[A-Za-z0-9]{1,15}$";
	
	private static final String TILE_PATTERN = "^[0-9]{1,3}$";
	
	private static final String NAME_PATTERN = "^[A-Za-z'a'=>'á|à|ả|ã|ạ|ă|ắ|ặ|ằ|ẳ|ẵ|â|ấ|ầ|ẩ|ẫ|ậ''d'=>'đ' 'e'=>'é|è|ẻ|ẽ|ẹ|ê|ế|ề|ể|ễ|ệ''i'=>'í|ì|ỉ|ĩ|ị' 'o'=>'ó|ò|ỏ|õ|ọ|ô|ố|ồ|ổ|ỗ|ộ|ơ|ớ|ờ|ở|ỡ|ợ' 'u'=>'ú|ù|ủ|ũ|ụ|ư|ứ|ừ|ử|ữ|ự' 'y'=>'ý|ỳ|ỷ|ỹ|ỵ' 'A'=>'Á|À|Ả|Ã|Ạ|Ă|Ắ|Ặ|Ằ|Ẳ|Ẵ|Â|Ấ|Ầ|Ẩ|Ẫ|Ậ''D'=>'Đ' 'E'=>'É|È|Ẻ|Ẽ|Ẹ|Ê|Ế|Ề|Ể|Ễ|Ệ''I'=>'Í|Ì|Ỉ|Ĩ|Ị' 'O'=>'Ó|Ò|Ỏ|Õ|Ọ|Ô|Ố|Ồ|Ổ|Ỗ|Ộ|Ơ|Ớ|Ờ|Ở|Ỡ|Ợ' 'U'=>'Ú|Ù|Ủ|Ũ|Ụ|Ư|Ứ|Ừ|Ử|Ữ|Ự' 'Y'=>'Ý|Ỳ|Ỷ|Ỹ|Y']{1,40}$";
	private static final String ID_VALIDATE_QUEQUAN = "^[A-Za-z'a'=>'á|à|ả|ã|ạ|ă|ắ|ặ|ằ|ẳ|ẵ|â|ấ|ầ|ẩ|ẫ|ậ''d'=>'đ' 'e'=>'é|è|ẻ|ẽ|ẹ|ê|ế|ề|ể|ễ|ệ''i'=>'í|ì|ỉ|ĩ|ị' 'o'=>'ó|ò|ỏ|õ|ọ|ô|ố|ồ|ổ|ỗ|ộ|ơ|ớ|ờ|ở|ỡ|ợ' 'u'=>'ú|ù|ủ|ũ|ụ|ư|ứ|ừ|ử|ữ|ự' 'y'=>'ý|ỳ|ỷ|ỹ|ỵ' 'A'=>'Á|À|Ả|Ã|Ạ|Ă|Ắ|Ặ|Ằ|Ẳ|Ẵ|Â|Ấ|Ầ|Ẩ|Ẫ|Ậ''D'=>'Đ' 'E'=>'É|È|Ẻ|Ẽ|Ẹ|Ê|Ế|Ề|Ể|Ễ|Ệ''I'=>'Í|Ì|Ỉ|Ĩ|Ị' 'O'=>'Ó|Ò|Ỏ|Õ|Ọ|Ô|Ố|Ồ|Ổ|Ỗ|Ộ|Ơ|Ớ|Ờ|Ở|Ỡ|Ợ' 'U'=>'Ú|Ù|Ủ|Ũ|Ụ|Ư|Ứ|Ừ|Ử|Ữ|Ự' 'Y'=>'Ý|Ỳ|Ỷ|Ỹ|Y' 0-9-]{1,200}$";	
	private static final String ID_VALIDATE_TUYEN = "^[A-Za-z'a'=>'á|à|ả|ã|ạ|ă|ắ|ặ|ằ|ẳ|ẵ|â|ấ|ầ|ẩ|ẫ|ậ''d'=>'đ' 'e'=>'é|è|ẻ|ẽ|ẹ|ê|ế|ề|ể|ễ|ệ''i'=>'í|ì|ỉ|ĩ|ị' 'o'=>'ó|ò|ỏ|õ|ọ|ô|ố|ồ|ổ|ỗ|ộ|ơ|ớ|ờ|ở|ỡ|ợ' 'u'=>'ú|ù|ủ|ũ|ụ|ư|ứ|ừ|ử|ữ|ự' 'y'=>'ý|ỳ|ỷ|ỹ|ỵ' 'A'=>'Á|À|Ả|Ã|Ạ|Ă|Ắ|Ặ|Ằ|Ẳ|Ẵ|Â|Ấ|Ầ|Ẩ|Ẫ|Ậ''D'=>'Đ' 'E'=>'É|È|Ẻ|Ẽ|Ẹ|Ê|Ế|Ề|Ể|Ễ|Ệ''I'=>'Í|Ì|Ỉ|Ĩ|Ị' 'O'=>'Ó|Ò|Ỏ|Õ|Ọ|Ô|Ố|Ồ|Ổ|Ỗ|Ộ|Ơ|Ớ|Ờ|Ở|Ỡ|Ợ' 'U'=>'Ú|Ù|Ủ|Ũ|Ụ|Ư|Ứ|Ừ|Ử|Ữ|Ự' 'Y'=>'Ý|Ỳ|Ỷ|Ỹ|Y' 0-9()]{1,100}$";	
	
	public static boolean validateTuyen(String id) {
		pattern = Pattern.compile(ID_VALIDATE_TUYEN);
		matcher = pattern.matcher(id);
		return matcher.matches();
	}



	// validate id
	public static boolean validateFieldname(String id) {
		pattern = Pattern.compile(NAME_PATTERN);
		matcher = pattern.matcher(id);
		return matcher.matches();
	}

	//validate tile
		public static boolean validateTiLe(String id) {
			pattern = Pattern.compile(TILE_PATTERN);
			matcher = pattern.matcher(id);
			return matcher.matches();
	}	
	
	//VALIDEATE BIENSO
		public static boolean validateBienSo(String id) {
			pattern = Pattern.compile(BIENSO_PATTERN);
			matcher = pattern.matcher(id);
			return matcher.matches();
		}
		
	// validate id nhanvien
	public static boolean validateMaNhanVien(String id) {
		pattern = Pattern.compile(ID_VALIDATE_MANV);
		matcher = pattern.matcher(id);
		return matcher.matches();
	}

	// validate id que quan
	public static boolean validateQueQuan(String id) {
		pattern = Pattern.compile(ID_VALIDATE_QUEQUAN);
		matcher = pattern.matcher(id);
		return matcher.matches();
	}

	// validate id
	public static boolean validateId(String id) {
		pattern = Pattern.compile(ID_PATTERN);
		matcher = pattern.matcher(id);
		return matcher.matches();
	}

	// validate name
	public static boolean validateName(String Name) {
		pattern = Pattern.compile(NAME_PATTERN);
		matcher = pattern.matcher(Name);
		return matcher.matches();
	}

	// validate price
	public static boolean validatePrice(String price) {
		pattern = Pattern.compile(PRICE_PATTERN);
		matcher = pattern.matcher(price);
		return matcher.matches();
	}

	public static boolean validateTelephone(String telephone) {
		pattern = Pattern.compile(TELEPHONE_PATTERN);
		matcher = pattern.matcher(telephone);
		return matcher.matches();
	}

	public static boolean validateSoCMND(String soCMND) {
		pattern = Pattern.compile(CMND_PATTERN);
		matcher = pattern.matcher(soCMND);
		return matcher.matches();
	}

	public static boolean validateUsername(String username) {
		pattern = Pattern.compile(USERNAME_PATTERN);
		matcher = pattern.matcher(username);
		return matcher.matches();
	}

	// validate email
	public static boolean validateEmail(String email) {
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(email);
		return matcher.matches();
	}

	// validate password
	public static boolean validatePassword(String password) {
		pattern = Pattern.compile(PASSWORD_PATTERN);
		matcher = pattern.matcher(password);
		return matcher.matches();
	}

	// validate date mm/dd/yy
	public static boolean validateDate(String date) {
		pattern = Pattern.compile(DATE_PATTERN);
		matcher = pattern.matcher(date);
		return matcher.matches();
	}

	// Ham ma hoa MD5
	public static String md5(String str) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md.update(str.getBytes());

		byte byteData[] = md.digest();
		// convert the byte to hex format method 1
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
					.substring(1));
		}

		return sb.toString();
	}

	public static String getAfterCurrentDate() {
		// lay ngay sau ngay hien tai
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
		Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
		int currentDay = localCalendar.get(Calendar.DATE);
		int currentMonth = localCalendar.get(Calendar.MONTH) + 1;
		int currentYear = localCalendar.get(Calendar.YEAR);
		String d = currentMonth + "/" + (currentDay + 1) + "/" + currentYear;// tang
																				// ngay
																				// len
																				// thanh
																				// 1
		Date da = null;

		try {
			da = dateFormat.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dateFormat.format(da);
	}

	public static String stringToHTMLString(String string) {
		StringBuffer sb = new StringBuffer(string.length());
		// true if last char was blank
		boolean lastWasBlankChar = false;
		int len = string.length();
		char c;

		for (int i = 0; i < len; i++) {
			c = string.charAt(i);
			if (c == ' ') {
				// blank gets extra work,
				// this solves the problem you get if you replace all
				// blanks with &nbsp;, if you do that you loss
				// word breaking
				if (lastWasBlankChar) {
					lastWasBlankChar = false;
					sb.append("&nbsp;");
				} else {
					lastWasBlankChar = true;
					sb.append(' ');
				}
			} else {
				lastWasBlankChar = false;
				//
				// HTML Special Chars
				if (c == '"')
					sb.append("&quot;");
				else if (c == '&')
					sb.append("&amp;");
				else if (c == '<')
					sb.append("&lt;");
				else if (c == '>')
					sb.append("&gt;");
				else if (c == '\n')
					// Handle Newline
					sb.append("&lt;br/&gt;");
				else {
					int ci = 0xffff & c;
					if (ci < 160)
						// nothing special only 7 Bit
						sb.append(c);
					else {
						// Not 7 Bit use the unicode system
						sb.append("&#");
						sb.append(new Integer(ci).toString());
						sb.append(';');
					}
				}
			}
		}
		return sb.toString();
	}

	// validate year
	public static boolean validateYear(String year) {
		pattern = Pattern.compile(YEAR_PATTERN);
		matcher = pattern.matcher(year);
		return matcher.matches();
	}
	

}
