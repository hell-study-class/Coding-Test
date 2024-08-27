select animal_type, count(*) as count from animal_ins
 where animal_type in ('dog', 'cat')
 group by animal_type
 order by animal_type;
