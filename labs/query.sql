select * from name_basics nb where nb.nconst ='nm0408348';

select * from title_principals tp where tp.nconst  ='nm0000018';

select * from title_basics tb 
join title_principals tp on tp.tconst = tb.tconst
where tp.nconst = 'nm0408348' -- 'nm0000018';