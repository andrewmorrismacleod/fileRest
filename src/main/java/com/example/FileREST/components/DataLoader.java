package com.example.FileREST.components;

import com.example.FileREST.models.File;
import com.example.FileREST.models.Folder;
import com.example.FileREST.models.User;
import com.example.FileREST.repositories.FileRepository;
import com.example.FileREST.repositories.FolderRepository;
import com.example.FileREST.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user1 = new User("Fred");
        userRepository.save(user1);

        Folder folder1 = new Folder("Junk", user1);
        folderRepository.save(folder1);

        Folder folder2 = new Folder("Important", user1);
        folderRepository.save(folder2);

        File file1 = new File("passwords", "txt", 45, folder1);
        fileRepository.save(file1);

        File file2 = new File("misc", "dat", 60, folder2);
        fileRepository.save(file2);

        File file3 = new File("commands", "txt", 105, folder2);
        fileRepository.save(file3);

        folder1.addFile(file1);
        folderRepository.save(folder1);

        folder2.addFile(file2);
        folderRepository.save(folder2);

        folder2.addFile(file3);
        folderRepository.save(folder2);

        user1.addFolder(folder1);
        userRepository.save(user1);

        user1.addFolder(folder2);
        userRepository.save(user1);
    }
}
