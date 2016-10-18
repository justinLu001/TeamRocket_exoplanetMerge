package PullData;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class pulldata {
	public static void main(String[] args){
		String urlEU = "http://exoplanet.eu/catalog/csv/";
		String urlNASA = "http://exoplanetarchive.ipac.caltech.edu/cgi-bin/nstedAPI/nph-nstedAPI?format=csv&";
		String tableNASA = "table=exoplanets&select=pl_hostname,pl_letter,pl_discmethod,pl_pnum,pl_orbper,pl_orbpererr1,pl_orbpererr2,pl_orbperlim,pl_orbsmax,pl_orbsmaxerr1,pl_orbsmaxerr2,pl_orbsmaxlim,pl_orbeccen,pl_orbeccenerr1,pl_orbeccenlim,pl_orbincl,pl_orbinclerr1,pl_orbinclerr2,pl_orbincllim,pl_bmassj,pl_bmassjerr1,pl_bmassjerr2,pl_bmassjlim,pl_bmassprov,pl_radj,pl_radjerr1,pl_radjerr2,pl_radjlim,pl_dens,pl_denserr1,pl_denserr2,pl_denslim,pl_ttvflag,pl_kepflag,pl_k2flag,pl_nnotes,ra_str,ra,dec_str,dec,st_dist,st_disterr1,st_disterr2,st_distlim,st_optmag,st_optmagerr,st_optmaglim,st_optmagblend,st_optband,st_teff,st_tefferr1,st_tefferr2,st_tefflim,st_teffblend,st_mass,st_masserr1,st_masserr2,st_masslim,st_massblend,st_rad,st_raderr1,st_raderr2,st_radlim,st_radblend,rowupdate";
		try{
			download(urlEU, "/Users/justinlu/desktop/exoplanet/exoplaent_eu.csv");
			download(urlNASA+tableNASA,"/Users/justinlu/desktop/exoplanet/exoplaent_NASA.csv");
		} catch (IOException e){
			e.printStackTrace();
		}
		
		
	}
	// download(url,file) example up there in main 
	
	public static void download (String urlStr, String file) throws IOException{
		URL url = new URL(urlStr);
		ReadableByteChannel rbc = Channels.newChannel(url.openStream());
		FileOutputStream fos = new FileOutputStream(file);
		System.out.println("File downloading");
		fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		fos.close();
		rbc.close();	
		System.out.println("File downloaded");
	}

}
