package positronic.satisfiability.demos.towerofhanoi;

public class Peg
{
	public Disk[] disk;

	public Peg(int disks) throws Exception
	{
		this.disk = new Disk[disks];
		for(int i=0;i<disks;i++)
			this.disk[i]=new Disk();
	}
}
