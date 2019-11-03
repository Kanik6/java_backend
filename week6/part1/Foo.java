public class Foo
{
	public static void main(String[] args)
	{
		if(Integer.parseInt(args[0]) % 2 == 0)
		{
			System.out.println("foo "+args[0]);
			System.exit(0);
		}
		else
		{
			System.out.println("bar "+args[0]);
			System.exit(0);
		}
	}
}