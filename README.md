<img src="https://user-images.githubusercontent.com/98073548/150498129-dc28ccb8-b30f-458b-a85b-da24f22db073.png" width=20% height=20%>

# Social Web Crawler
> The growths of online Social Networks in scale and amount of information has been astronomical in
recent years. The analyses of the structure of online social networks have thus drawn much
research interests.

Hence to collect, segregate and analyses the information on Social Media and the characteristics of the respective structure
so formed by such information we need some tool. Hence this project.

Web Crawler is a program, which finds information from the World Wide Web in a
systematic and automated manner. Our target is also to get user data from social networking
sites.
The Crawler would be given a **seed url** (url of social networking site) through which it would get
into the world of social network by logging in as an authentic user. From the seed url the crawler
would index all the possible links present on the page and in the process would also gather the
attributes present on that webpage which would be later on used for analysis purpose. 

Once data is collected an **adjacency matrix** will be created and a **graph** will be created. 

## Installing / Getting started

A quick introduction of the minimal setup you need to get this application up &
running.

```
step 1: Keep the DSWC.jar handy
step 2: goto shell and enter command
        java -jar DSWC.jar```
step3 : (optional) save this command in a .bat file so next time just double click this .bat file and "VOILÀ" its done.

Here you should say what actually happens when you execute the code above.

### Initial Configuration

Recommend using eclipse IDE to import project content of the DSWC.zip this would make life much easier if you plan on making changes to the code.

## Developing

Here's a brief intro about what a developer must do in order to start developing
the project further:

```shell
git clone https://github.com/shiva-kant-mishra/social_web_crawler
```

## Features

What's all the bells and whistles this project can perform?

* To finds information from the social networks in a systematic and automated manner.
* To implement intelligent crawling of Social Web by “Cluster coverage sampling
algorithm" which would enable to crawl for data intelligently rather than blindly
following a random path. 
* To collecting data from social networking sites as per requirement of social network
analysis.
* Avoid irrelevant information from a large set of social data.

## GUI Flow

Below snapshot shows the admin login window of DSWC. Here username and password are
taken from user and validated. According to verification the next
windows are displayed. “About us” button shows information about developers. 

![Screenshot from 2022-01-21 15-12-24](https://user-images.githubusercontent.com/98073548/150504303-4bda7b97-ba02-4d11-9d70-60738fad3470.png)

The Below snapshot shows the window of the home page of DSWC . Here are the four
buttons BASIC , FACEBOOK , GOOGLE, WHAT NEXT. The Basic button will show you the
basic crawling of any website. The Facebook button will start crawling the friend list of the
seed user (which will be the facebook wall of the user whose credentials are used to login) provided , Google will crawl the GOOGLE+ of the provided seed user and what
next shows the feature scope of DSWC. (**Caveat**: currently the program runs only for Facebook)

![Screenshot from 2022-01-21 15-22-16](https://user-images.githubusercontent.com/98073548/150505876-84a35bb9-f117-42e4-a786-116f5b162a68.png)

Below snapshot shows the output window for viewing extracted data of seed user . the
friendUrl , name , location of friends of seed user are displayed in text area. Here three
options are provided PDF,BACK, EXIT

![Screenshot from 2022-01-21 15-35-14](https://user-images.githubusercontent.com/98073548/150507951-09fa46e1-ddfe-47ce-9ade-02840bb41bcd.png)

Below screenshot shows the dashboard of the facebook login . The adjacency matrix shows
the inter connection between friends and graph is also of the same matrix. 

![Screenshot from 2022-01-21 15-32-49](https://user-images.githubusercontent.com/98073548/150507631-d260541a-67eb-4311-9a06-729df9540a9f.png)

## Result

Below snapshot shows the extracted data having information about friendURL,
friendname and his location of friends of the seed user. All the information is stored
in the databse and then can be exported to CSV file .this snapshot shows the CSV
view of crawled data. 
![csv blurred](https://user-images.githubusercontent.com/98073548/150510586-f355a317-5c0c-4d58-a2dd-44f77b8d2646.jpg)

Adjaency Matrix

![Screenshot from 2022-01-21 15-39-44](https://user-images.githubusercontent.com/98073548/150510941-65d8d08f-53f9-442d-a22d-f2fa57dbf3f0.png)

Adjaency List

![Screenshot from 2022-01-21 15-40-11](https://user-images.githubusercontent.com/98073548/150510989-365ab399-9ba5-464f-a7fa-11cd58718c74.png)


NOTE: The data crawled from the facebook are primarily stored in the MYSQL database
in the friendlist and locqation tabel.this data is then represented in the form of
adjaency list and adjaency matrix for the social network analysis.
The output of this crawler is a adjaency list and adjaency matrix which can be
used by the social network analysist for his anaylsis.The adjaency list and adjaency
matrix depicts the relationship between the friends of seed user.
This adjecy matrix can be used for the visualistaion by plotting the graph which
graphically shows the relationship between the different nodes and their degree of
connection between each other nodes.

## Development Challenges
### Facebook challenges
Facebook does not allow any bot, spider or a program to login Facebook .it provides a method to login
using OUTH authentication but it has lots of restrictions, including a limited access of information from
those who are also using outh authentication.
HTML UNIT is a way to login Facebook via program by simulating a web browser in its program.to login
,facebook verifies many details from browser apart from login id and password.
Even after login,facebook timely checks session and token id and generate exceptions.html unit fails in
supressing exceptions and warnings and generate timely reports by analysing the activities of program.
Facebook continuously checks and monitors the activities o and throws following type of errors and
exceptions in some cases:
![Screenshot from 2022-01-21 16-02-14](https://user-images.githubusercontent.com/98073548/150512137-76658d3a-ec19-424b-a681-ba28c0ad198e.png)

### Html unit challenges
Html unit throws exceptions and warnings which while login facebook and fetching data from
facebook. Since Html unit is a under construction API(application programming interface) so it is not as
good as to handle warnings and security checks by facebook.
Some of the exceptions and warnings due to under construction api of Html unit can be seen in below screenshot:
![Screenshot from 2022-01-21 16-04-30](https://user-images.githubusercontent.com/98073548/150512612-2a16d828-c4ca-49b9-a7e5-e34c70994e8a.png)

### Graph construction challenges
Graph plotting and its visualisation has lot of limitations and challenges due to high overhead of degree
calculation.
Graph plotting incurs overhead of O(n*n) to plot graph from a adjacency matrix of n nodes.


## Contributing

"If you'd like to contribute, please fork the repository and use a feature
branch. Pull requests are warmly welcome."

## License

The project is the result of combined work done by
* Shiva Kant Mishra (shivakmishra1995@gmail.com)
* Vaibhav Singh
* Sumit Rai
