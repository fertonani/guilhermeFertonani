package to;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import dao.MovimentoDAO;
import model.Conta;
import model.Extrato;

public class ExtratoTO {
	private Date data;
	private char tipo;
	private int numDoc, idHistorico;
	private double valor;
	private ArrayList<Extrato> listaExtrato;
	private Conta conta;
	private MovimentoDAO movimento;
	private double saldo;

	public ExtratoTO(int idHistorico, Date data, char tipo, int numDoc, double valor) {
		this.idHistorico = idHistorico;
		this.data = data;
		this.tipo = tipo;
		this.numDoc = numDoc;
		this.valor = valor;

	}
	public ExtratoTO(){
		
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public int getNumDoc() {
		return numDoc;
	}

	public void setNumDoc(int numDoc) {
		this.numDoc = numDoc;
	}

	public int getIdHistorico() {
		return idHistorico;
	}

	public void setIdHistorico(int idHistorico) {
		this.idHistorico = idHistorico;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}


	public void setListaExtrato(ArrayList<Extrato> listaExtrato) {
		this.listaExtrato = listaExtrato;
	}

	public ArrayList<Extrato> getLista(){
		return listaExtrato;
	}
	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public MovimentoDAO getMovimento() {
		return movimento;
	}

	public void setMovimento(MovimentoDAO movimento) {
		this.movimento = movimento;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}