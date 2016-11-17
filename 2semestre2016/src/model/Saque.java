package model;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Observable;

import dao.MovimentoDAO;
import to.SaqueTO;

public class Saque extends Observable {
	private Conta conta;
	private Dispenser dispenser;
	private double valor;
	private MovimentoDAO movimento;
	private SaqueTO to;
	private boolean efetuado;
	public Saque(Conta conta, Double valor) throws SQLException{
		this.conta = conta;
		this.valor = valor;
		dispenser = new Dispenser();
		movimento = new MovimentoDAO(conta);
		efetuado = false;
	}
	public Saque(Conta conta, Double valor, boolean efetuado) throws SQLException{
		this.conta = conta;
		this.valor = valor;
		this.efetuado = efetuado;
		dispenser = new Dispenser();
		movimento = new MovimentoDAO(conta);
		efetuado = false;
	}
	public boolean verificarSaldo(){
		if(conta.getSaldo() >= valor) return true;
		return false;
	}
	public boolean sacar() throws FileNotFoundException{
		if(dispenser.sacar(valor)){
			funcaoSacar();
			return true;
		}
		return false;
	}
	public void funcaoSacar(){
		conta.setSaldo(conta.getSaldo() - valor);
		efetuado = true;
		movimento.incluir('D', valor);
	}
	
	public boolean verificarNotas() throws FileNotFoundException{
		return dispenser.verificarNotas(valor);
	}
	
	public double getValor(){
		return valor;
	}
	public Conta getConta(){
		return conta;
	}
	public void criarTO(){
		to = new SaqueTO();
		to.setValor(valor);
	}
	public boolean getEfetuado() {
		return efetuado;
	}
	public void setEfetuado(boolean efetuado) {
		this.efetuado = efetuado;
	}
	public Saque getSaque(){
		return this;
	}
}
