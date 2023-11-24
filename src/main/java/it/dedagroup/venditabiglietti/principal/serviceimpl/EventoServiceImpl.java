package it.dedagroup.venditabiglietti.principal.serviceimpl;


import java.util.List;

import it.dedagroup.venditabiglietti.principal.dto.response.EventoMicroDTO;
import org.springframework.stereotype.Service;

import it.dedagroup.venditabiglietti.principal.model.Evento;
import it.dedagroup.venditabiglietti.principal.service.EventoServiceDef;
import it.dedagroup.venditabiglietti.principal.service.GeneralCallService;

@Service
public class EventoServiceImpl implements EventoServiceDef, GeneralCallService{

    private String servicePath="http://localhost:8081/evento/";

	@Override
	public void eliminaEvento(long id) {
		callPost(servicePath+"delete/"+id, id, String.class);
		
	}


    @Override
    public List<EventoMicroDTO> trovaEventiFuturi() {
        String mioPath=servicePath+"trovaEventiFuturi";
        EventoMicroDTO[] listaEventiFuturi =callGet(mioPath,null, EventoMicroDTO[].class);
        return List.of(listaEventiFuturi);
    }

}
