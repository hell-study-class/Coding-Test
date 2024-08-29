select count(*) as fish_count, name.fish_name from fish_info info
  join fish_name_info name
    on info.fish_type = name.fish_type
 group by name.fish_name
 order by fish_count desc;