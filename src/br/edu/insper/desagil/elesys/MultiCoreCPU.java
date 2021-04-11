package br.edu.insper.desagil.elesys;

import java.util.List;

public class MultiCoreCPU {
	private List<SingleCoreCPU> cores;
	private double overhead;

	public MultiCoreCPU(List<SingleCoreCPU> cores, double overhead) {
		this.cores = cores;
		this.overhead = overhead;
	}

	public List<SingleCoreCPU> getCores() {
		return this.cores;
	}

	public double getPower() {
		double power = 0;
		for (SingleCoreCPU core: this.cores) {
			power += core.getPower();
		}
		return (1 - this.overhead) * power;
	}
}
