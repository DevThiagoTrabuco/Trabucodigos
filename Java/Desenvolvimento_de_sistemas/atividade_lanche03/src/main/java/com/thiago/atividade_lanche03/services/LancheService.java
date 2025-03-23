package com.thiago.atividade_lanche03.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;

import com.thiago.atividade_lanche03.entities.Lanche;

@Service
public class LancheService {
    private String filePath = "../atividade_lanche03/repositories/destination/";

    public Lanche getById(int id){
        return null;
    }

    public boolean exists(int id){
        return true;
    }

    private String getFileExtension(Path path){
        String fileName = path.getFileName().toString();
        int lastDotIndex = fileName.lastIndexOf('.');

        if(lastDotIndex == -1 || lastDotIndex == fileName.length() - 1){
            return "";
        }
        return fileName.substring(lastDotIndex + 1);
    }

    public boolean save(Lanche lanche){
        Path path = Paths.get(lanche.getImage());
        Path destination = Paths.get(String.format("%s%d.%s", filePath, lanche.getId(), getFileExtension(path)));

        if(Files.exists(path)){
            try{
                Files.copy(path, destination, StandardCopyOption.REPLACE_EXISTING);
                lanche.setImage(destination.toString());
                return true;
            } catch (IOException e){
                String error = e.getMessage();
                System.out.println(error);
                return false;
            }
        }
        return false;
    }

    public boolean delete(Lanche lanche) {
        Path path = Paths.get(lanche.getImage());

        if (Files.exists(path)) {
            try {
                Files.delete(path);
                return true;
            } catch (IOException e) {
                return false;
            }
        }
        return false;
    }
}