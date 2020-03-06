--
create view user_migration as
select distinct icon, id_douban as username, url from demo.user
--
create view starring_migration as
select cover_url, name as foreign_name, name, url_douban as douban_link, url_imdb as imdb_link
from demo.starring;
--
create view directorScreenwriter_migration as
select cover_url, name as foreign_name, is_director, is_screenwriter, name, url_douban as douban_link, url_imdb as imdb_link
from demo.director_screenwriter;
--
create view genre_migration as
select distinct description, foreign_name, name
from demo.genre;
--
create view movie_screenwriter_migration as
select m.id as movie_id, ds.id as screenwriter_id, msr.ranking
from demo.movie_screenwriter_relation msr,
     recommendsystem.movie m,
     recommendsystem.director_screenwriter ds
where instr(m.douban_link, '%' + msr.movie_id + '%')
  and msr.url = ds.douban_link
--
create view movie_director_migration as
select m.id as movie_id, ds.id as director_id, mdr.ranking
from demo.movie_director_relation mdr,
     recommendsystem.movie m,
     recommendsystem.director_screenwriter ds
where instr(m.douban_link, '%' + mdr.movie_id + '%')
  and mdr.url = ds.douban_link
--
create view genre_migration as
select distinct `demo`.`genre`.`description`  AS `description`,
                `demo`.`genre`.`foreign_name` AS `foreign_name`,
                `demo`.`genre`.`name`         AS `name`
from `demo`.`genre`;
--
create view movie_starring_migration as
select m.id as movie_id, s.id as starring_id, msr.ranking
from demo.movie_starring_relation msr,
     recommendsystem.movie m,
     recommendsystem.starring s
where instr(m.douban_link, '%'+msr.movie_id+'%')
and s.douban_link = msr.url
order by movie_id;
--
create view movie_migration as
select `demo`.`movie`.`name`         AS `name`,
       `demo`.`movie`.`foreign_name` AS `foreign_name`,
       `demo`.`movie`.`length`       AS `length`,
       `demo`.`movie`.`language`     AS `language`,
       `demo`.`movie`.`area`         AS `area`,
       `demo`.`movie`.`release_date` AS `release_date`,
       `demo`.`movie`.`cover_url`    AS `cover_url`,
       `demo`.`movie`.`rate`         AS `rate`,
       `demo`.`movie`.`rate_num`     AS `votes`,
       `demo`.`movie`.`weight`       AS `rate_weight`,
       `demo`.`movie`.`url_douban`   AS `douban_link`,
       `demo`.`movie`.`id_douban`    AS `id_douban`,
       `demo`.`movie`.`url_imdb`     AS `imdb_link`,
       `demo`.`movie`.`profile`      AS `profile`
from `demo`.`movie`;


-- 创建 comment_migration
create view comment_migration as
select u.id as user, m.id as movie, c.content, c.date, c.rate, c.votes
from recommendsystem.movie m,
     demo.comment c,
     recommendsystem.user u
where instr(m.douban_link, '%' + c.movie_id + '%')
  and u.username = c.user_id
;
-- 创建 review_migration
create view review_migration as
select u.id as user, m.id as movie, r.title,r.content, r.date, r.rate, r.votes
from recommendsystem.movie m,
     demo.review r,
     recommendsystem.user u
where instr(m.douban_link, '%' + r.movie_id + '%')
  and u.username = r.user_id
;





