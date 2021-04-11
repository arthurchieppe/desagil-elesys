package br.edu.insper.desagil.elesys;

import java.util.ArrayList;
import java.util.List;

public class Computer {
	private List<CPU> procs;

	public Computer() {
		this.procs = new ArrayList<>();
	}

	public void add(CPU proc) {
		this.procs.add(proc);
	}

	public double getProcPower() {
		double s = 0;
		for (CPU proc: this.procs) {
			s += proc.getPower();
		}
		return s;
	}
}
