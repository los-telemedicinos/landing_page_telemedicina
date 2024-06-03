package pe.edu.upc.DocSeekerTP.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.DocSeekerTP.Repository.TechnicalFileRepository;
import pe.edu.upc.DocSeekerTP.Services.TechnicalFileService;
import pe.edu.upc.DocSeekerTP.entities.Technical_file;

@Service
public class TechnicalFileServiceImpl implements TechnicalFileService {
    @Autowired
    TechnicalFileRepository technicalFileRepository;

    @Override
    public Technical_file save(Technical_file technical_file){
        return technicalFileRepository.save(technical_file);
    }
}
