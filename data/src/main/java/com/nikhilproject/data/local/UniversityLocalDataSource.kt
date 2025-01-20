package com.nikhilproject.data.local

import com.nikhilproject.data.R
import com.nikhilproject.domain.model.Course
import com.nikhilproject.domain.model.University

object CourseDataSource {

    private val mitCourses = listOf(
        Course(
            name = "Aerospace Engineering",
            image = R.drawable.aerospace_img,
            professor = "F. Scott Fitzgerald"
        ),
        Course(
            name = "Chemistry",
            image = R.drawable.ai_img,
            professor = "Harper Lee"
        ),
        Course(
            name = "Business Analytics",
            image = R.drawable.ba_img,
            professor = "George Orwell"
        ),
        Course(
            name = "Artificial Intelligence",
            image = R.drawable.ai_img,
            professor = "J.D. Salinger"
        ),
        Course(
            name = "Material Science",
            image = R.drawable.materialscience_img,
            professor = "Jane Austen"
        ),
        Course(
            name = "Media Arts",
            image = R.drawable.mediaarts_img,
            professor = "Cormac McCarthy"
        ),
        Course(
            name = "Nuclear Science",
            image = R.drawable.nuclearscience_img,
            professor = "Toni Morrison"
        )
    )

    private val harvardCourses = listOf(
        Course(
            name = "Entrepreneurship in the Arts",
            image = R.drawable.entrepreneurship_in_the_arts_img,
            professor = "Frank Herbert"
        ),
        Course(
            name = "Neuroscience and Society",
            image = R.drawable.neuroscience_and_society_img,
            professor = "Isaac Asimov"
        ),
        Course(
            name = "The Science of happiness",
            image = R.drawable.science_of_happiness_img,
            professor = "William Gibson"
        ),
        Course(
            name = "Anthrology of Food",
            image = R.drawable.the_anthropology_of_food,
            professor = "Neal Stephenson"
        ),
        Course(
            name = "History of Science and Technology",
            image = R.drawable.history_of_science_and_technology,
            professor = "Ursula K. Le Guin"
        ),
        Course(
            name = "The art of Teching and Learning",
            image = R.drawable.the_art_of_teaching_and_learning,
            professor = "Dan Simmons"
        ),
        Course(
            name = "The Politics if Modern Africa",
            image = R.drawable.the_politics_of_modern_africa,
            professor = "H.G. Wells"
        ),
        Course(
            name = "Entrepreneurship in the Arts",
            image = R.drawable.entrepreneurship_in_the_arts_img,
            professor = "Frank Herbert"
        ),
        Course(
            name = "Neuroscience and Society",
            image = R.drawable.neuroscience_and_society_img,
            professor = "Isaac Asimov"
        ),
        Course(
            name = "The Science of happiness",
            image = R.drawable.science_of_happiness_img,
            professor = "William Gibson"
        ),
        Course(
            name = "Anthrology of Food",
            image = R.drawable.the_anthropology_of_food,
            professor = "Neal Stephenson"
        ),
        Course(
            name = "History of Science and Technology",
            image = R.drawable.history_of_science_and_technology,
            professor = "Ursula K. Le Guin"
        ),
        Course(
            name = "The art of Teching and Learning",
            image = R.drawable.the_art_of_teaching_and_learning,
            professor = "Dan Simmons"
        ),
        Course(
            name = "The Politics if Modern Africa",
            image = R.drawable.the_politics_of_modern_africa,
            professor = "H.G. Wells"
        )
    )

    private val stanfordCourses = listOf(
        Course(
            name = "Data Science",
            image = R.drawable.data_science_img,
            professor = "J.R.R. Tolkien"
        ),
        Course(
            name = "Economics",
            image = R.drawable.economics_img,
            professor = "J.K. Rowling"
        ),
        Course(
            name = "Environmental Studied",
            image = R.drawable.evs_img,
            professor = "Patrick Rothfuss"
        ),
        Course(
            name = "Humanities",
            image = R.drawable.humanities_img,
            professor = "Brandon Sanderson"
        ),
        Course(
            name = "MBA",
            image = R.drawable.mba_img,
            professor = "Brandon Sanderson"
        ),
        Course(
            name = "NeuroScience",
            image = R.drawable.neuroscience_img,
            professor = "George R.R. Martin"
        ),
        Course(
            name = "Chemical Engineering",
            image = R.drawable.chem_img,
            professor = "Scott Lynch"
        )
    )

    private val cambridgeCources = listOf(
        Course(
            name = "Computer Science",
            image = R.drawable.computer_science,
            professor = "Dan Brown"
        ),
        Course(
            name = "Economics",
            image = R.drawable.economics_img,
            professor = "Gillian Flynn"
        ),
        Course(
            name = "Engineering",
            image = R.drawable.engineering,
            professor = "Stieg Larsson"
        ),
        Course(
            name = "History",
            image = R.drawable.history,
            professor = "Liane Moriarty"
        ),
        Course(
            name = "LLB",
            image = R.drawable.llb,
            professor = "Gillian Flynn"
        ),
        Course(
            name = "MBBS",
            image = R.drawable.mbbs,
            professor = "Tana French"
        ),
        Course(
            name = "Natural Science",
            image = R.drawable.natural_sciences,
            professor = "Alex Michaelides"
        ),
        Course(
            name = "Psychology",
            image = R.drawable.psychology,
            professor = "A.J. Finn"
        )
    )

    private val oxfordCourses = listOf(
        Course(
            name = "Archaeology and Antrhopology",
            image = R.drawable.archaeology_and_anthropology,
            professor = "Yuval Noah Harari"
        ),
        Course(
            name = "Classical Latin and Greek Latin",
            image = R.drawable.classics,
            professor = "Tara Westover"
        ),
        Course(
            name = "Egyptology",
            image = R.drawable.egyptology,
            professor = "Rebecca Skloot"
        ),
        Course(
            name = "Geography",
            image = R.drawable.geography,
            professor = "Michelle Obama"
        ),
        Course(
            name = "Music",
            image = R.drawable.music,
            professor = "David McCullough"
        ),
        Course(
            name = "Philosophy, Politics, and Economics",
            image = R.drawable.ppe,
            professor = "Laura Hillenbrand"
        ),
        Course(
            name = "Theology and Religion",
            image = R.drawable.theolohy_and_religion,
            professor = "Susan Cain"
        ),
        Course(
            name = "Archaeology and Antrhopology",
            image = R.drawable.archaeology_and_anthropology,
            professor = "Yuval Noah Harari"
        ),
        Course(
            name = "Classical Latin and Greek Latin",
            image = R.drawable.classics,
            professor = "Tara Westover"
        ),
        Course(
            name = "Egyptology",
            image = R.drawable.egyptology,
            professor = "Rebecca Skloot"
        ),
        Course(
            name = "Geography",
            image = R.drawable.geography,
            professor = "Michelle Obama"
        ),
        Course(
            name = "Music",
            image = R.drawable.music,
            professor = "David McCullough"
        ),
        Course(
            name = "Philosophy, Politics, and Economics",
            image = R.drawable.ppe,
            professor = "Laura Hillenbrand"
        ),
        Course(
            name = "Theology and Religion",
            image = R.drawable.theolohy_and_religion,
            professor = "Susan Cain"
        )
    )

    private val caltechCourses = listOf(
        Course(
            name = "Astrophysics",
            image = R.drawable.astrophysics_img,
            professor = "Stephen King"
        ),
        Course(
            name = "Biology",
            image = R.drawable.biology_img,
            professor = "Bram Stoker"
        ),
        Course(
            name = "Chemistry",
            image = R.drawable.chemistry_img,
            professor = "Mary Shelley"
        ),
        Course(
            name = "Computer Science",
            image = R.drawable.cs_img,
            professor = "Josh Malerman"
        ),
        Course(
            name = "Engineering",
            image = R.drawable.engineering,
            professor = "Shirley Jackson"
        ),
        Course(
            name = "Geology",
            image = R.drawable.geology_img,
            professor = "Stephen King"
        ),
        Course(
            name = "Mathematics",
            image = R.drawable.mathematics_img,
            professor = "William Peter Blatty"
        ),
        Course(
            name = "Astrophysics",
            image = R.drawable.astrophysics_img,
            professor = "Stephen King"
        ),
        Course(
            name = "Biology",
            image = R.drawable.biology_img,
            professor = "Bram Stoker"
        ),
        Course(
            name = "Chemistry",
            image = R.drawable.chemistry_img,
            professor = "Mary Shelley"
        ),
        Course(
            name = "Computer Science",
            image = R.drawable.cs_img,
            professor = "Josh Malerman"
        ),
        Course(
            name = "Engineering",
            image = R.drawable.engineering,
            professor = "Shirley Jackson"
        ),
        Course(
            name = "Geology",
            image = R.drawable.geology_img,
            professor = "Stephen King"
        ),
        Course(
            name = "Mathematics",
            image = R.drawable.mathematics_img,
            professor = "William Peter Blatty"
        )
    )

    val genreList = listOf(
        University(
            genreName = "MIT University",
            coverImage = R.drawable.mit_img,
            universities = mitCourses
        ),
        University(
            genreName = "Harvard University",
            coverImage = R.drawable.harvard_img,
            universities = harvardCourses
        ),
        University(
            genreName = "Stanford University",
            coverImage = R.drawable.stanford_university_img,
            universities = stanfordCourses
        ),
        University(
            genreName = "Cambridge University",
            coverImage = R.drawable.university_of_uk,
            universities = cambridgeCources
        ),
        University(
            genreName = "Oxford University",
            coverImage = R.drawable.oxford_university,
            universities = oxfordCourses
        ),
        University(
            genreName = "Caltech University",
            coverImage = R.drawable.caltech_img,
            universities = caltechCourses
        )
    )
}