package com.observador.principal;

public class Observacion {
	
	Integer cantidadEstudiantes,
			albumesLlenosAmbiente,
			totalLaminasCompradasAmbiente,
			laminasCompradasAlbumesLlenos,
			cantidadAmistades,
			cantidadIntercambiosAlbumesLlenos,
			cantidadIntercambiosAmbiente;
	
	public Observacion() {
		cantidadEstudiantes = 0;
		albumesLlenosAmbiente = 0;
		totalLaminasCompradasAmbiente = 0;
		laminasCompradasAlbumesLlenos = 0;
		cantidadAmistades = 0;
		cantidadIntercambiosAlbumesLlenos = 0;
		cantidadIntercambiosAmbiente = 0;
	}
	
	public Integer getCantidadEstudiantes() {
		return cantidadEstudiantes;
	}

	public void setCantidadEstudiantes(Integer cantidadEstudiantes) {
		this.cantidadEstudiantes = cantidadEstudiantes;
	}

	public Integer getAlbumesLlenosAmbiente() {
		return albumesLlenosAmbiente;
	}

	public void setAlbumesLlenosAmbiente(Integer albumesLlenosAmbiente) {
		this.albumesLlenosAmbiente = albumesLlenosAmbiente;
	}

	public Integer getTotalLaminasCompradasAmbiente() {
		return totalLaminasCompradasAmbiente;
	}

	public void setTotalLaminasCompradasAmbiente(Integer totalLaminasCompradasAmbiente) {
		this.totalLaminasCompradasAmbiente = totalLaminasCompradasAmbiente;
	}

	public Integer getLaminasCompradasAlbumesLlenos() {
		return laminasCompradasAlbumesLlenos;
	}

	public void setLaminasCompradasAlbumesLlenos(Integer laminasCompradasAlbumesLlenos) {
		this.laminasCompradasAlbumesLlenos = laminasCompradasAlbumesLlenos;
	}

	public Integer getPromedioLaminasCompradasPorEstudiante() {
		return totalLaminasCompradasAmbiente / cantidadEstudiantes ;
	}


	public Integer getPromedioLaminasCompradasParaAlbumesLlenos() {
		return laminasCompradasAlbumesLlenos / laminasCompradasAlbumesLlenos;
	}
	
	public Integer getPromedioLaminasIntercambiadasAmbiente() {
		return cantidadIntercambiosAmbiente / cantidadEstudiantes;
	}
	
	public Integer getPromedioLaminasIntercambiadasAlbumesLlenos() {
		return cantidadIntercambiosAlbumesLlenos / albumesLlenosAmbiente;
	}

	public Integer getCantidadAmistades() {
		return cantidadAmistades;
	}

	public void setCantidadAmistades(Integer cantidadAmistades) {
		this.cantidadAmistades = cantidadAmistades;
	}

	public String getCSVLine() {
		return "" + cantidadEstudiantes + ","
						+ cantidadAmistades + ","
						+ albumesLlenosAmbiente + ","
						+ totalLaminasCompradasAmbiente+","
						+ laminasCompradasAlbumesLlenos + ","
						+ getPromedioLaminasCompradasPorEstudiante() + ","
						+ getPromedioLaminasCompradasParaAlbumesLlenos() + ","
						+ getPromedioLaminasIntercambiadasAmbiente() + ","
						+ getPromedioLaminasCompradasParaAlbumesLlenos() + "\n";
	}

	public Integer getCantidadIntercambios() {
		return cantidadIntercambiosAlbumesLlenos;
	}

	public void setCantidadIntercambios(Integer cantidadIntercambios) {
		this.cantidadIntercambiosAlbumesLlenos = cantidadIntercambios;
	}

	@Override
	public String toString() {
		return "Observacion [cantidadEstudiantes=" + cantidadEstudiantes + ", albumesLlenosAmbiente="
				+ albumesLlenosAmbiente + ", totalLaminasCompradasAmbiente=" + totalLaminasCompradasAmbiente
				+ ", laminasCompradasAlbumesLlenos=" + laminasCompradasAlbumesLlenos + ", cantidadAmistades="
				+ cantidadAmistades + ", cantidadIntercambiosAlbumesLlenos=" + cantidadIntercambiosAlbumesLlenos
				+ ", cantidadIntercambiosAmbiente=" + cantidadIntercambiosAmbiente + "]";
	}
	
}
