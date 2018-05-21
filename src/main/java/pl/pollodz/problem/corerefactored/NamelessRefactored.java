package pl.pollodz.problem.corerefactored;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NamelessRefactored {

    @Autowired
    MapperRefactoredRepository repository;

    public void namelessRefactored() {

        List<MapperRefactored> mappers = repository.findAll();
        System.out.println();
    }
}
