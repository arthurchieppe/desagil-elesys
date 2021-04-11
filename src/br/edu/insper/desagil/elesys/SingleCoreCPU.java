package br.edu.insper.desagil.elesys;

public class SingleCoreCPU extends CPU {
	private double power;

	public SingleCoreCPU(double power) {
		this.power = power;
	}

	@Override
	public double getPower() {
		return power;
	}
}
