package pe.edu.upc.DocSeekerTP.Services;

import pe.edu.upc.DocSeekerTP.entities.Technical_file;

import java.util.List;

public interface TechnicalFileService {
    List<Technical_file> listAll();

    public Technical_file save(Technical_file technical_file);
}
