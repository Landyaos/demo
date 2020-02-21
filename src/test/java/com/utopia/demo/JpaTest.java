package com.utopia.demo;

import com.utopia.demo.entity.DirectorScreenwriter;
import com.utopia.demo.entity.Genre;
import com.utopia.demo.entity.Movie;
import com.utopia.demo.entity.Starring;
import com.utopia.demo.repository.DirectorScreenwriterRepository;
import com.utopia.demo.repository.GenreRepository;
import com.utopia.demo.repository.MovieRepository;
import com.utopia.demo.repository.StarringRepository;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.DataInput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootTest
public class JpaTest {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private StarringRepository starringRepository;
    @Autowired
    private DirectorScreenwriterRepository directorScreenwriterRepository;


    @Test
    public void generateTestDate() throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        genreRepository.save(new Genre("动作", "action", "动作类型，666"));
        genreRepository.save(new Genre("科幻", "science fiction", "科幻类型，666"));
        genreRepository.save(new Genre("冒险", "adventure", "冒险类型，666"));
        genreRepository.save(new Genre("奇幻", "fantasy", "奇幻类型，666"));
        genreRepository.save(new Genre("歌舞", "musical", "歌舞类型，666"));
        genreRepository.save(new Genre("剧情", "drama", "剧情类型，666"));
        genreRepository.save(new Genre("犯罪", "crime", "犯罪类型，666"));

        starringRepository.save(new Starring("小罗伯特·唐尼", "Robert Downey Jr.", "https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p56339.webp", "https://movie.douban.com/celebrity/1016681/", ""));
        starringRepository.save(new Starring("克里斯·埃文斯", "Chris Evans", "https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1359877729.49.webp", "https://movie.douban.com/celebrity/1017885/", ""));
        starringRepository.save(new Starring("斯嘉丽·约翰逊","Scarlett Johansson","https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p37050.webp","https://movie.douban.com/celebrity/1054453/",""));
        starringRepository.save(new Starring("克里斯·海姆斯沃斯","Chris Hemsworth","https://movie.douban.com/celebrity/1021959/","https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1425725663.63.webp",""));
        starringRepository.save(new Starring("杰瑞米·雷纳","Jeremy Renner","https://movie.douban.com/celebrity/1013770/","https://img9.doubanio.com/view/celebrity/s_ratio_celebrity/public/p15184.webp",""));
        starringRepository.save(new Starring("克里斯汀·贝尔","Kristen Bell","https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1395152016.01.webp","https://movie.douban.com/celebrity/1031240/",""));
        starringRepository.save(new Starring("伊迪娜·门泽尔","Idina Menzel","https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1397731339.63.webp","https://movie.douban.com/celebrity/1116746/",""));
        starringRepository.save(new Starring("范·迪塞尔","Vin Diesel","https://img9.doubanio.com/view/celebrity/s_ratio_celebrity/public/p53186.webp","https://movie.douban.com/celebrity/1041020/",""));
        starringRepository.save(new Starring("杰森·斯坦森","Jason Statham","https://img9.doubanio.com/view/celebrity/s_ratio_celebrity/public/p424.webp","https://movie.douban.com/celebrity/1049484/",""));
        starringRepository.save(new Starring("莱昂纳多·迪卡普里奥","Leonardo DiCaprio","https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p470.webp","https://movie.douban.com/celebrity/1041029/",""));

        directorScreenwriterRepository.save(new DirectorScreenwriter("詹姆斯·卡梅隆", "James Cameron", "https://img9.doubanio.com/view/celebrity/s_ratio_celebrity/public/p33715.webp", true, false, "https://movie.douban.com/celebrity/1022571/", ""));
        directorScreenwriterRepository.save(new DirectorScreenwriter("乔恩·费儒", "Jon Favreau", "https://img9.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1405546733.56.webp", true, true, "https://movie.douban.com/celebrity/1027164/", ""));
        directorScreenwriterRepository.save(new DirectorScreenwriter("安东尼·罗素", "Anthony Russo", "https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1555672594.77.webp", true, true, "https://movie.douban.com/celebrity/1321812/", ""));
        directorScreenwriterRepository.save(new DirectorScreenwriter("乔·罗素", "Joe Russo", "https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1525505053.79.webp", true, true, "https://movie.douban.com/celebrity/1321812/", ""));
        directorScreenwriterRepository.save(new DirectorScreenwriter("温子仁", "James Wan", "https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1509950363.8.webp", true, true, "https://movie.douban.com/celebrity/1032122/", ""));
        directorScreenwriterRepository.save(new DirectorScreenwriter("克里斯·巴克", "Chris Buck", "https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p48399.webp", true, true, "https://movie.douban.com/celebrity/1279552/", ""));
        directorScreenwriterRepository.save(new DirectorScreenwriter("珍妮弗·李", "Jennifer Lee", "https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1392548591.79.webp", true, true, "https://movie.douban.com/celebrity/1335174/", ""));
        Date date = simpleDateFormat.parse("2017-06-05");

        Set<Genre> genreSet = new HashSet<>();
        Set<DirectorScreenwriter> directorSet = new HashSet<>();
        Set<Starring> starringSet = new HashSet<>();

        genreSet.add(genreRepository.findById(1L));
        genreSet.add(genreRepository.findById(2L));
        genreSet.add(genreRepository.findById(3L));

        directorSet.add(directorScreenwriterRepository.findById(6));
        directorSet.add(directorScreenwriterRepository.findById(7));

        starringSet.add(starringRepository.findById(6));
        starringSet.add(starringRepository.findById(7));

        Movie movie = new Movie("冰雪奇缘", "Frozen", 181, "英语 / 冰岛语", "美国", simpleDateFormat.parse("2013-12-21"), 2000000.05f, "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2166640945.webp", 9.5f, 50000000L, "14%,25%,52%,25%,12%", "", "https://movie.douban.com/subject/4202982/", "", directorSet, directorSet, starringSet, genreSet);
        movieRepository.save(movie);

        genreSet.clear();
        directorSet.clear();
        starringSet.clear();

        genreSet.add(genreRepository.findById(1L));
        genreSet.add(genreRepository.findById(2L));
        genreSet.add(genreRepository.findById(3L));
        genreSet.add(genreRepository.findById(4L));

        directorSet.add(directorScreenwriterRepository.findById(3));
        directorSet.add(directorScreenwriterRepository.findById(4));

        starringSet.add(starringRepository.findById(1));
        starringSet.add(starringRepository.findById(3));
        starringSet.add(starringRepository.findById(2));
        starringSet.add(starringRepository.findById(4));

        movie = new Movie("美国队长3", "Captain America: Civil War", 181, "英语 / 日语 / 科萨语", "美国", simpleDateFormat.parse("2016-04-26"), 10000.56f, "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2332503406.webp", 6.5f, 10000L, "14%,25%,52%,25%,12%", "", "https://movie.douban.com/subject/25820460/", "", directorSet, directorSet, starringSet, genreSet);
        movieRepository.save(movie);

        genreSet.clear();
        directorSet.clear();
        starringSet.clear();

        genreSet.add(genreRepository.findById(3L));
        genreSet.add(genreRepository.findById(4L));
        genreSet.add(genreRepository.findById(5L));

        directorSet.add(directorScreenwriterRepository.findById(3));
        directorSet.add(directorScreenwriterRepository.findById(4));

        starringSet.add(starringRepository.findById(1));
        starringSet.add(starringRepository.findById(3));
        starringSet.add(starringRepository.findById(2));
        starringSet.add(starringRepository.findById(4));

        movie = new Movie("美国队长3", "Captain America: Civil War", 181, "英语 / 日语 / 科萨语", "美国", simpleDateFormat.parse("2016-04-26"), 10000.56f, "https://img9.doubanio.com/view/photo/s_ratio_poster/public/p2332503406.webp", 6.5f, 10000L, "14%,25%,52%,25%,12%", "", "https://movie.douban.com/subject/25820460/", "", directorSet, directorSet, starringSet, genreSet);
        movieRepository.save(movie);




    }
}
