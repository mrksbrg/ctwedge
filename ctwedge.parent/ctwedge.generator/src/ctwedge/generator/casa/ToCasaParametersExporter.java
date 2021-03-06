package ctwedge.generator.casa;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.IFileSystemAccess2;

import ctwedge.ctWedge.CitModel;
import ctwedge.ctWedge.Parameter;
import ctwedge.generator.util.Utility;

public class ToCasaParametersExporter {
	// exports 	the part of the model containing the parameters (not the constraints)
		void doGenerate(Resource resource, IFileSystemAccess2 fsa, int n) {
			fsa.generateFile(resource.getClass().getName()+".ctw", getCasaModel(resource, n));
		}

		String getCasaModel(Resource resource, int n) {
			return toCasaCode((CitModel)resource.getContents().get(0), n);
		}

		String className(Resource res) {
			String name = res.getURI().lastSegment();
			return name.substring(0, name.indexOf('.'));
		}

		public String toCasaCode(CitModel sm, int n) {
			String s = n+"\n"+sm.getParameters().size()+"\n";
			for (Parameter param : sm.getParameters()) s+=Utility.getSize(param)+" ";
			return s;
		}

		
}
