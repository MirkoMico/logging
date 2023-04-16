package co.develhope.logging.services;


import org.springframework.stereotype.Service;

@Service
public class BasicService {

        public Integer[] calculation(int n1,int n2){
            Integer[] calculation_array={n1*n1,n2*n2};
            return calculation_array;
        }

        }

