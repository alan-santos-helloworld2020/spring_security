M.AutoInit();


function deletar(event){
    if (!confirm("Deseja realmente excluir!")){
        event.preventDefault();
        return false;
        
    }else{
        return true;
    }
    
}

