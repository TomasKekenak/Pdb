package sk.upjs.gursky.pdb;

import java.nio.ByteBuffer;
import java.util.Collections;

import sk.upjs.gursky.bplustree.BPObject;

public class SalaryOffsetEntry implements BPObject<SalaryKey, SalaryOffsetEntry> {

	private static final long serialVersionUID = 6636012031385997564L;
	int salary; //4B
	long offset; // 8B
	
	public SalaryOffsetEntry() {
		
	}	

	public SalaryOffsetEntry(int salary, long offset) {
		super();
		this.salary = salary;
		this.offset = offset;
	}


	@Override
	public int compareTo(SalaryOffsetEntry o) {
		return Integer.compare(this.getSalary(), o.getSalary());
	}

	@Override
	public void load(ByteBuffer bb) {		
		salary = bb.getInt();
		offset = bb.getLong();
	}

	@Override
	public void save(ByteBuffer bb) {
		bb.putInt(salary);
		bb.putLong(offset);

	}

	@Override
	public int getSize() {
		return 12; // 4 + 8
	}

	@Override
	public SalaryKey getKey() {
		return new SalaryKey(salary);
	}
	
	public int getSalary() {
		return salary;
	}
	
	public long getOffset() {
		return offset;
	}

	@Override
	public String toString() {
		return "SalaryAndOffsetEntry [salary=" + salary + ", offset=" + offset + "]";
	}

}
