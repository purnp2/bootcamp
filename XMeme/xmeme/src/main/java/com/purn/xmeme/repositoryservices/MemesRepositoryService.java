package com.purn.xmeme.repositoryservices;

import java.util.List;
import java.util.Optional;
import com.purn.xmeme.data.MemeEntity;
import com.purn.xmeme.exceptions.MemeNotFoundException;
import com.purn.xmeme.repository.MemesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemesRepositoryService {
    @Autowired
    MemesRepository memesRepository;

    public Optional<List<MemeEntity>> getLatest100Memes() {
        // return memesRepository.find().sort({Timestamp: -1}).limit(100);
        Optional<List<MemeEntity>> optionalLatest100MemeEntities =
                memesRepository.findTop100ByOrderByTimeStampDesc();
        return optionalLatest100MemeEntities;
    }

    public Optional<MemeEntity> getMemeById(String id) throws MemeNotFoundException {
        Optional<MemeEntity> optionalMemeById = memesRepository.findById(id);
        return optionalMemeById;
    }

    public MemeEntity saveAndRetrunMeme(MemeEntity inputMemeEntity) {
        MemeEntity outputMemeEntity = memesRepository.save(inputMemeEntity);
        return outputMemeEntity;
    }

    public boolean isDuplicateMeme(String name, String url, String caption) {
        return memesRepository.existsByNameAndUrlAndCaption(name, url, caption);
    }
}
