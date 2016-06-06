package modelo;

public class ModeloSpec {
	public String buildSpec(OraObject oraObject){
		String objectName = oraObject.getName().toLowerCase();
		int objectVersion = oraObject.getVersion();
		
		String specDocument =  "require_relative '../spec/spec_helper'\n"
                + "\n"
                + "# encoding: utf-8\n"
                + "describe 'Testa rotinas da " + objectName + "' do\n"
                + "\n"
                + "	  after(:all) do\n"
                + "	    plsql.rollback\n"
                + "	  end\n"
                + "\n"
                + "	  it 'Retorna número da versão' do\n"
                + "\n"
                + "	    v_version = " + objectVersion + "\n"
                + "\n"
                + "	    expect(plsql." + objectName + ".version()).to eq(v_version)\n"
                + "\n"
                + "	  end\n"
                + "\n"
                + "end";
		
		return specDocument;
	}
}