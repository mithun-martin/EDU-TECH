package com.EdTech.Edtech.service;

import com.EdTech.Edtech.model.Lesson;
import com.EdTech.Edtech.repository.LessonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonService {

    @Autowired
    private LessonRepo lessonRepository;

    // ✅ Get all lessons
    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

    // ✅ Get lesson by ID
    public Optional<Lesson> getLessonById(Long id) {
        return lessonRepository.findById(id);
    }

    // ✅ Add a new lesson
    public Lesson addLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    // ✅ Update an existing lesson
    public Lesson updateLesson(Long id, Lesson updatedLesson) {
        return lessonRepository.findById(id)
                .map(lesson -> {
                    lesson.setTitle(updatedLesson.getTitle());
                    lesson.setContent(updatedLesson.getContent());
                    lesson.setCourse(updatedLesson.getCourse());
                    return lessonRepository.save(lesson);
                })
                .orElseThrow(() -> new RuntimeException("Lesson not found with id: " + id));
    }

    // ✅ Delete a lesson by ID
    public void deleteLesson(Long id) {
        lessonRepository.deleteById(id);
    }
}
