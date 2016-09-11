package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import model.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import to.*;

public class JSonFacade {
	
	public static StringBuilder montaJSon(HttpServletRequest request)
			throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = request.getReader();
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line).append('\n');
			}
		} finally {
			reader.close();
		}
		return sb;
	}

	public static String listToJSon(ArrayList<Extrato> lista) {
		JSONArray vetor = new JSONArray();
		for (Extrato to : lista) {
			JSONObject object = new JSONObject();
			try {
				object.put("idHistorico", to.getIdHistorico());
				object.put("data", to.getData());
				object.put("tipo", to.getTipo());
				object.put("numDoc", to.getNumDoc());
				object.put("valor", to.getValor());
				vetor.put(object);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return vetor.toString();
	}

	public static Extrato jSonToExtrato(String json) throws IOException, ParseException{
		try{
			JSONObject registro = new JSONObject(json);
			int id = registro.getInt("idHistorico");
			String data = registro.getString("data");
			char tipo = registro.getString("tipo").charAt(0);
			int numDoc = registro.getInt("numDoc");
			double valor = registro.getDouble("valor");
			
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			return new Extrato(id, (java.util.Date)formatter.parse(data), tipo, numDoc, valor);
		} catch(JSONException jsone){
			jsone.printStackTrace();
			throw new IOException(jsone);
		}
	}
	
	public static String extratoToJSon(Extrato to) throws IOException {
		JSONObject object = new JSONObject();
		try {
			object.put("idHistorico", to.getIdHistorico());
			object.put("data", to.getData());
			object.put("tipo", to.getTipo());
			object.put("numDoc", to.getNumDoc());
			object.put("valor", to.getValor());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return object.toString();
	}

	public static String errorToJSon(Exception e) {
		JSONObject object = new JSONObject();
		try {
			object.put("error", e.toString());
		} catch (JSONException e1) {
			e.printStackTrace();
		}
		return object.toString();
	}
	//Exercicio a
	public static Transferencia jSonToTransferencia(String json) throws IOException, ParseException, SQLException{
		try{
			JSONObject registro = new JSONObject(json);
			Conta id = (Conta) registro.get("remetente");
			String agencia = registro.getString("agencia");
			String conta = registro.getString("conta");
			double valor = registro.getDouble("valor");
			
			return new Transferencia(id, agencia, conta, valor);
		} catch(JSONException jsone){
			jsone.printStackTrace();
			throw new IOException(jsone);
		}
	}
	//Exercicio B
	public static String transferenciaToJSon(Transferencia to) throws IOException {
		JSONObject object = new JSONObject();
		try {
			object.put("remetente", to.getRemetente());
			object.put("agencia", to.getAgencia());
			object.put("conta", to.getConta());
			object.put("valor", to.getValor());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return object.toString();
	}
}
