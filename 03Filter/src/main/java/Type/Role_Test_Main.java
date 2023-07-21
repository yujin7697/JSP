package Type;

public class Role_Test_Main {
	public static void main(String[] args) {
		System.out.println(Role.ROLE_USER);
		System.out.println(Role.ROLE_ADMIN);
		
		System.out.println(Role.ROLE_USER.ordinal());
		System.out.println(Role.ROLE_ADMIN.ordinal());
		
		System.out.println(Role.ROLE_USER.ordinal() < Role.ROLE_ADMIN.ordinal());
	}
}
