select COUNT(*) as COUNT
from ECOLI_DATA
where (GENOTYPE & 2) != 2 AND
    ((GENPTYPE & 1) = 1 or (GENPTYPE & 4) = 4);