package org.geogebra.desktop.geogebra3D.euclidian3D.opengl;

import java.nio.IntBuffer;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

import org.geogebra.common.awt.GColor;
import org.geogebra.common.geogebra3D.euclidian3D.EuclidianView3D;
import org.geogebra.common.geogebra3D.euclidian3D.draw.DrawPoint3D;
import org.geogebra.common.geogebra3D.euclidian3D.draw.Drawable3D;
import org.geogebra.common.geogebra3D.euclidian3D.openGL.GLBuffer;
import org.geogebra.common.geogebra3D.euclidian3D.openGL.GLFactory;
import org.geogebra.common.geogebra3D.euclidian3D.openGL.ManagerShaders;
import org.geogebra.common.geogebra3D.euclidian3D.openGL.ManagerShaders.Geometry;
import org.geogebra.common.kernel.Matrix.Coords;
import org.geogebra.desktop.geogebra3D.euclidian3D.opengl.RendererJogl.GL2ES2;

/**
 * renderer using shaders and drawElements()
 * 
 * @author mathieu
 *
 */
public class RendererShadersElements extends RendererShaders {

	/**
	 * constructor
	 * 
	 * @param view
	 *            3D view
	 * @param useCanvas
	 *            say if we use GLCanvas or GLJPanel
	 */
	public RendererShadersElements(EuclidianView3D view, boolean useCanvas) {
		super(view, useCanvas);
	}


	protected void draw() {

		resetOneNormalForAllVertices();
		disableTextures();

		setModelViewIdentity();


		// init drawing matrix to view3D toScreen matrix
		setMatrixView();

		setLightPosition();
		setLight(0);
		disableCulling();

		enableMultisample();


		// ////////////
		// tests

		// points test

		// disableLighting();
		setColor(-1, 0, 0, 1);


		updateBuffers();

		jogl.getGL2ES2().glEnableVertexAttribArray(GLSL_ATTRIB_POSITION);
		jogl.getGL2ES2().glEnableVertexAttribArray(GLSL_ATTRIB_COLOR);
		jogl.getGL2ES2().glEnableVertexAttribArray(GLSL_ATTRIB_NORMAL);




		// elements
		jogl.getGL2ES2().glBindBuffer(GL2ES2.GL_ELEMENT_ARRAY_BUFFER,
				vboIndices);
		jogl.getGL2ES2().glBufferData(GL.GL_ELEMENT_ARRAY_BUFFER, bufferL * 4,
				bufferI, RendererJogl.GL_STREAM_DRAW);
		jogl.getGL2().glDrawElements(GL2.GL_TRIANGLES, bufferL,
				GL.GL_UNSIGNED_INT, 0);
		jogl.getGL2().glFlush();

		jogl.getGL2ES2().glDisableVertexAttribArray(GLSL_ATTRIB_POSITION);
		jogl.getGL2ES2().glDisableVertexAttribArray(GLSL_ATTRIB_COLOR);
		jogl.getGL2ES2().glDisableVertexAttribArray(GLSL_ATTRIB_NORMAL);


		// // simple test
		//
		// enableAlphaTest();
		// enableBlending();
		// enableDash();
		// setDashTexture(Textures.DASH_DOTTED);
		// enableLighting();
		//
		// setColor(-1, -1, -1, -1);
		//
		// int length = 4;
		//
		// GLBuffer fbVertices = GLFactory.prototype.newBuffer();
		// fbVertices.allocate(length * 3);
		// fbVertices.put(0);
		// fbVertices.put(0);
		// fbVertices.put(0);
		//
		// fbVertices.put(0);
		// fbVertices.put(10);
		// fbVertices.put(0);
		//
		// fbVertices.put(10);
		// fbVertices.put(10);
		// fbVertices.put(0);
		//
		// fbVertices.put(10);
		// fbVertices.put(0);
		// fbVertices.put(0);
		//
		// fbVertices.setLimit(length * 3);
		//
		// GLBuffer fbNormals = GLFactory.prototype.newBuffer();
		// fbNormals.allocate(length * 3);
		// fbNormals.put(0);
		// fbNormals.put(0);
		// fbNormals.put(10);
		//
		// fbNormals.put(0);
		// fbNormals.put(0);
		// fbNormals.put(1);
		//
		// fbNormals.put(0);
		// fbNormals.put(0);
		// fbNormals.put(1);
		//
		// fbNormals.put(0);
		// fbNormals.put(0);
		// fbNormals.put(1);
		//
		// fbNormals.setLimit(length * 3);
		//
		// GLBuffer fbColors = GLFactory.prototype.newBuffer();
		// fbColors.allocate(length * 4);
		// fbColors.put(1);
		// fbColors.put(0);
		// fbColors.put(0);
		// fbColors.put(1);
		//
		// fbColors.put(0);
		// fbColors.put(1);
		// fbColors.put(0);
		// fbColors.put(1);
		//
		// fbColors.put(0);
		// fbColors.put(0);
		// fbColors.put(1);
		// fbColors.put(1);
		//
		// fbColors.put(0);
		// fbColors.put(0);
		// fbColors.put(0);
		// fbColors.put(1);
		//
		// fbColors.setLimit(length * 4);
		//
		// GLBuffer fbTextures = GLFactory.prototype.newBuffer();
		// fbTextures.allocate(length * 2);
		// fbTextures.put(0);
		// fbTextures.put(0);
		//
		// fbTextures.put(10);
		// fbTextures.put(0);
		//
		// fbTextures.put(10);
		// fbTextures.put(0);
		//
		// fbTextures.put(10);
		// fbTextures.put(0);
		//
		// fbTextures.setLimit(length * 2);
		//
		// // DRAW ELEMENTS
		//
		// jogl.getGL2ES2().glEnableVertexAttribArray(GLSL_ATTRIB_POSITION);
		// jogl.getGL2ES2().glEnableVertexAttribArray(GLSL_ATTRIB_COLOR);
		// jogl.getGL2ES2().glEnableVertexAttribArray(GLSL_ATTRIB_NORMAL);
		// jogl.getGL2ES2().glEnableVertexAttribArray(GLSL_ATTRIB_TEXTURE);
		//
		// int numBytes;
		//
		// jogl.getGL2ES2().glBindBuffer(GL2ES2.GL_ARRAY_BUFFER, vboVertices);
		// numBytes = length * 12; // 4 bytes per float * 3 coords per vertex
		// glBufferData(numBytes, fbVertices);
		// jogl.getGL2ES2().glVertexAttribPointer(GLSL_ATTRIB_POSITION, 3,
		// GL2ES2.GL_FLOAT, false, 0, 0);
		//
		// jogl.getGL2ES2().glBindBuffer(GL2ES2.GL_ARRAY_BUFFER, vboColors);
		// numBytes = length * 16;
		// glBufferData(numBytes, fbColors);
		// jogl.getGL2ES2().glVertexAttribPointer(GLSL_ATTRIB_COLOR, 4,
		// GL2ES2.GL_FLOAT, false, 0, 0);
		//
		// jogl.getGL2ES2().glBindBuffer(GL2ES2.GL_ARRAY_BUFFER, vboNormals);
		// numBytes = length * 12; // 4 bytes per float * 3 coords per vertex
		// glBufferData(numBytes, fbNormals);
		// jogl.getGL2ES2().glVertexAttribPointer(GLSL_ATTRIB_NORMAL, 3,
		// GL2ES2.GL_FLOAT, false, 0, 0);
		//
		// jogl.getGL2ES2().glBindBuffer(GL2ES2.GL_ARRAY_BUFFER,
		// vboTextureCoords);
		// numBytes = length * 8;
		// glBufferData(numBytes, fbTextures);
		// jogl.getGL2ES2().glVertexAttribPointer(GLSL_ATTRIB_TEXTURE, 2,
		// GL2ES2.GL_FLOAT, false, 0, 0);
		//
		// // elements
		// IntBuffer indicesBuf;
		// indicesBuf = IntBuffer.allocate(6);
		// indicesBuf.put(0);
		// indicesBuf.put(1);
		// indicesBuf.put(2);
		// indicesBuf.rewind();
		// jogl.getGL2().glDrawElements(GL2.GL_TRIANGLES, 3, GL.GL_UNSIGNED_INT,
		// indicesBuf);
		// indicesBuf.put(0);
		// indicesBuf.put(2);
		// indicesBuf.put(3);
		// indicesBuf.rewind();
		// jogl.getGL2().glDrawElements(GL2.GL_TRIANGLES, 3, GL.GL_UNSIGNED_INT,
		// indicesBuf);
		// jogl.getGL2().glFlush();
		//
		// jogl.getGL2ES2().glDisableVertexAttribArray(GLSL_ATTRIB_POSITION);
		// jogl.getGL2ES2().glDisableVertexAttribArray(GLSL_ATTRIB_COLOR);
		// jogl.getGL2ES2().glDisableVertexAttribArray(GLSL_ATTRIB_NORMAL);
		// jogl.getGL2ES2().glDisableVertexAttribArray(GLSL_ATTRIB_TEXTURE);
	}

	private GLBuffer bufferV, bufferC, bufferN;
	private IntBuffer bufferI;
	private int bufferL;

	private boolean bufferUpdated = false;

	private void updateBuffers() {

		if (bufferUpdated) {
			return;
		}

		bufferL = 0;
		for (Drawable3D d : drawable3DLists
				.getList(Drawable3D.DRAW_TYPE_POINTS)) {
			// App.debug("(" + d.getGeometryIndex() + ") " + d.getGeoElement());
			Geometry geometry = ((ManagerShaders) getGeometryManager())
					.getGeometry(d.getGeometryIndex());
			bufferL += geometry.getLength();
			// App.debug("" + geometry.getType());
		}
		// App.debug("" + lv);

		bufferV = GLFactory.prototype.newBuffer();
		bufferV.allocate(bufferL * 3);
		bufferC = GLFactory.prototype.newBuffer();
		bufferC.allocate(bufferL * 4);
		bufferN = GLFactory.prototype.newBuffer();
		bufferN.allocate(bufferL * 3);
		bufferI = IntBuffer.allocate(bufferL * 3);

		int index = 0;
		for (Drawable3D d : drawable3DLists
				.getList(Drawable3D.DRAW_TYPE_POINTS)) {
			// App.debug("(" + d.getGeometryIndex() + ") " + d.getGeoElement());
			Coords center = ((DrawPoint3D) d).getCenter();
			double radius = center.getW() * DrawPoint3D.DRAW_POINT_FACTOR
					/ view3D.getScale();
			Geometry geometry = ((ManagerShaders) getGeometryManager())
					.getGeometry(d.getGeometryIndex());
			GLBuffer vertices = geometry.getVertices();
			GLBuffer normals = geometry.getNormals();
			GColor color = d.getGeoElement().getObjectColor();
			for (int i = 0; i < geometry.getLength(); i++) {

				bufferV.put(center.getX() + vertices.get() * radius);
				bufferV.put(center.getY() + vertices.get() * radius);
				bufferV.put(center.getZ() + vertices.get() * radius);

				bufferC.put(color.getRed() / 255.0);
				bufferC.put(color.getGreen() / 255.0);
				bufferC.put(color.getBlue() / 255.0);
				bufferC.put(color.getAlpha() / 255.0);

				bufferN.put(normals.get());
				bufferN.put(normals.get());
				bufferN.put(normals.get());

				bufferI.put(index);
				index++;
			}
			vertices.rewind();
			normals.rewind();

		}
		bufferV.setLimit(bufferL * 3);
		bufferC.setLimit(bufferL * 4);
		bufferN.setLimit(bufferL * 3);
		bufferI.rewind();

		jogl.getGL2ES2().glBindBuffer(GL2ES2.GL_ARRAY_BUFFER, vboVertices);
		glBufferData(bufferL * 12, bufferV);
		jogl.getGL2ES2().glVertexAttribPointer(GLSL_ATTRIB_POSITION, 3,
				GL2ES2.GL_FLOAT, false, 0, 0);

		jogl.getGL2ES2().glBindBuffer(GL2ES2.GL_ARRAY_BUFFER, vboColors);
		glBufferData(bufferL * 16, bufferC);
		jogl.getGL2ES2().glVertexAttribPointer(GLSL_ATTRIB_COLOR, 4,
				GL2ES2.GL_FLOAT, false, 0, 0);

		jogl.getGL2ES2().glBindBuffer(GL2ES2.GL_ARRAY_BUFFER, vboNormals);
		glBufferData(bufferL * 12, bufferN);
		jogl.getGL2ES2().glVertexAttribPointer(GLSL_ATTRIB_NORMAL, 3,
				GL2ES2.GL_FLOAT, false, 0, 0);

		bufferUpdated = true;
	}

}
