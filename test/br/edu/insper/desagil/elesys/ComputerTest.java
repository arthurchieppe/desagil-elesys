package br.edu.insper.desagil.elesys;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComputerTest {
	private static double DELTA = 0.000001;

	private Computer c;

	@BeforeEach
	public void setUp() {
		c = new Computer();
	}

	@Test
	public void oneProc() {
		c.add(new SingleCoreCPU(1.5));
		assertEquals(1.5, c.getProcPower(), DELTA);
	}

	@Test
	public void twoProcs() {
		c.add(new SingleCoreCPU(1.5));
		c.add(new SingleCoreCPU(3.75));
		assertEquals(5.25, c.getProcPower(), DELTA);
	}

	@Test
	public void oneMultiProc() {
		List<SingleCoreCPU> cores1 = new ArrayList<>();
		cores1.add(new SingleCoreCPU(2.25));
		cores1.add(new SingleCoreCPU(4.5));
		MultiCoreCPU proc1 = new MultiCoreCPU(cores1, 0.1);
		c.add(proc1);
		assertEquals(6.075, c.getProcPower(), DELTA);
	}

	@Test
	public void twoMultiProcs() {
		List<SingleCoreCPU> cores1 = new ArrayList<>();
		cores1.add(new SingleCoreCPU(1.5));
		cores1.add(new SingleCoreCPU(3.75));
		MultiCoreCPU proc1 = new MultiCoreCPU(cores1, 0.1);
		List<SingleCoreCPU> cores2 = new ArrayList<>();
		cores2.add(new SingleCoreCPU(2.25));
		cores2.add(new SingleCoreCPU(4.5));
		MultiCoreCPU proc2 = new MultiCoreCPU(cores2, 0.2);
		c.add(proc1);
		c.add(proc2);
		assertEquals(10.125, c.getProcPower(), DELTA);
	}
}
