package br.edu.insper.desagil.elesys;

import java.util.ArrayList;
import java.util.List;

public class Computer {
	private List<SingleCoreCPU> singleProcs;
	private List<MultiCoreCPU> multiProcs;

	public Computer() {
		this.singleProcs = new ArrayList<>();
		this.multiProcs = new ArrayList<>();
	}

	public void add(SingleCoreCPU proc) {
		this.singleProcs.add(proc);
	}

	public void add(MultiCoreCPU proc) {
		this.multiProcs.add(proc);
	}

	public double getProcPower() {
		double s = 0;
		for (SingleCoreCPU singleProc: this.singleProcs) {
			s += singleProc.getPower();
		}
		for (MultiCoreCPU multiProc: this.multiProcs) {
			s += multiProc.getPower();
		}
		return s;
	}
}
