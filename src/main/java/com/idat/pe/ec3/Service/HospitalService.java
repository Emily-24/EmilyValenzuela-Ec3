package com.idat.pe.ec3.Service;

import java.util.List;

import com.idat.pe.ec3.Dto.HospitalDTORequest;
import com.idat.pe.ec3.Dto.HospitalDTOResponse;

public interface HospitalService {
	
	void guardarHospital(HospitalDTORequest hospital);
	void actualizarHospital(HospitalDTORequest hospital);
	void eliminarHopsital(Integer id);
	List<HospitalDTOResponse> listarHospitales();
	HospitalDTOResponse obtnerHospitalId(Integer id);
	
}
